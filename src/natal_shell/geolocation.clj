(ns
 natal-shell.geolocation
 "This namespace is automatically generated from the React Native docs.")
(clojure.core/defmacro
 get-current-position
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.getCurrentPosition)
   (clojure.core/list 'js/ReactNative.Geolocation)
   args)))
(clojure.core/defmacro
 watch-position
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.watchPosition)
   (clojure.core/list 'js/ReactNative.Geolocation)
   args)))
(clojure.core/defmacro
 clear-watch
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.clearWatch)
   (clojure.core/list 'js/ReactNative.Geolocation)
   args)))
(clojure.core/defmacro
 stop-observing
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.stopObserving)
   (clojure.core/list 'js/ReactNative.Geolocation)
   args)))
