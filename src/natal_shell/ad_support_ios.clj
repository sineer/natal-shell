(ns
 natal-shell.ad-support-ios
 "This namespace is automatically generated from the React Native docs.")
(clojure.core/defmacro
 get-advertising-id
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.getAdvertisingId)
   (clojure.core/list 'js/ReactNative.AdSupportIOS)
   args)))
(clojure.core/defmacro
 get-advertising-tracking-enabled
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.getAdvertisingTrackingEnabled)
   (clojure.core/list 'js/ReactNative.AdSupportIOS)
   args)))
