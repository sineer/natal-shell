(ns natal-shell.scraper
  (:require
    [clojure.core.async :refer [go <!!]]
    [natal-shell.utils :refer [to-kebab to-snake]]
    [clojure.pprint :refer [pprint]]
    [clojure.java.io :as io]
    [clojure.string :refer [trim]]
    [net.cgrand.enlive-html :refer [html-resource select nth-child text-node]]))


(def ns-prefix "natal-shell.")
(def base-url  "https://facebook.github.io/react-native/")
(def entry-url "docs/getting-started.html")
(def base-path "src/natal_shell/")
(def comp-file "components_list")
(def animated-components (map #(str "Animated." %) ["View" "Text" "Image"]))
(def constructors {"Animated" #{"Value" "ValueXY"}})


(defn select-doc-section [n]
  [[:.nav-docs-section (nth-child n)] :a])


(defn select-name [tag]
  (->> tag :content first :content (some #(when (string? %) %))))


(defn fetch! [url]
  (go
    (html-resource (java.net.URL. (str base-url url)))))


(defn fetch-comps! [page]
  (go
    (->> (select page (select-doc-section 5))
      (map #(fetch! (get-in % [:attrs :href])))
      doall
      (map <!!)
      (map #(select % [:h1 :> text-node]))
      (map first)
      (map trim))))


(defn fetch-apis! [page]
  (go
    (->> (select page (select-doc-section 6))
      (map #(fetch! (get-in % [:attrs :href])))
      doall
      (map <!!)
      (map
        (fn [page]
          (let [prop-sections (select page [:.props])]
            [(-> (select page [:h1 :> text-node]) first trim)
             {:methods    (map select-name (select (first prop-sections) [:.prop]))
              :properties (map select-name (select (second prop-sections) [:.prop]))}]))))))


(defn make-ns [name]
  `(~'ns ~(symbol (str ns-prefix name))
    "This namespace is automatically generated from the React Native docs."))


(defn method-macro [react-ns js-name]
  `(defmacro ~(symbol (to-kebab js-name)) [& ~'args]
     `(~'~(symbol (str "." js-name))
       ~'~(symbol (str "js/ReactNative." react-ns))
       ~@~'args)))

(defn constructor-macro [react-ns]
 `(defmacro ~(symbol (to-kebab react-ns)) [& ~'args]
    `(~'~(symbol (str "js/ReactNative." react-ns "."))
       ~@~'args)))

(defn constructor-macro' [react-ns js-name]
  `(defmacro ~(symbol (to-kebab js-name)) [& ~'args]
     `(~'~(symbol (str "js/ReactNative." react-ns "." js-name "."))
        ~@~'args)))


(defn property-macro [react-ns js-name]
  `(defmacro ~(symbol (to-kebab js-name)) []
     `(~'~(symbol (str ".-" js-name))
        ~'~(symbol (str "js/ReactNative." react-ns)))))


(defn make-writer [path]
  (io/writer (io/file (str base-path path ".clj"))))


(defn init []
  (let [entry-page (<!! (fetch! entry-url))]
    (go
      (with-open [w (make-writer comp-file)]
        (binding [*out* w]
          (pprint (make-ns "components-list"))
          (pprint `(def ~'components ~(-> (fetch-comps! entry-page)
                                          <!!
                                          (concat animated-components)
                                          sort
                                          vec))))))

    (doseq [[k {:keys [methods properties]}] (<!! (fetch-apis! entry-page))]
      (go
        (with-open [w (make-writer (to-snake k))]
          (binding [*out* w]
            (pprint (make-ns (to-kebab k)))
            (doseq [m methods]
              (pprint
                (if (= m "constructor")
                  (constructor-macro k)
                  (method-macro k m))))
            (doseq [p properties]
              (pprint
                ((if (contains? (get constructors k) p)
                  constructor-macro'
                  property-macro) k p)))))))))


(init)
