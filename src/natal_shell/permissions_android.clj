(ns
 natal-shell.permissions-android
 "This namespace is automatically generated from the React Native docs.")
(clojure.core/defmacro
 permissions-android
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list 'js/ReactNative.PermissionsAndroid.)
   args)))
(clojure.core/defmacro
 check-permission
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.checkPermission)
   (clojure.core/list 'js/ReactNative.PermissionsAndroid)
   args)))
(clojure.core/defmacro
 request-permission
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.requestPermission)
   (clojure.core/list 'js/ReactNative.PermissionsAndroid)
   args)))
