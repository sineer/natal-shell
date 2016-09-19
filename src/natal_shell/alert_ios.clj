(ns
 natal-shell.alert-ios
 "This namespace is automatically generated from the React Native docs.")
(clojure.core/defmacro
 alert
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.alert)
   (clojure.core/list 'js/ReactNative.AlertIOS)
   args)))
(clojure.core/defmacro
 prompt
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.prompt)
   (clojure.core/list 'js/ReactNative.AlertIOS)
   args)))
(clojure.core/defmacro
 alert-type 
 []
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.-AlertType )
   (clojure.core/list 'js/ReactNative.AlertIOS))))
(clojure.core/defmacro
 alert-button-style 
 []
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.-AlertButtonStyle )
   (clojure.core/list 'js/ReactNative.AlertIOS))))
(clojure.core/defmacro
 buttons-array 
 []
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.-ButtonsArray )
   (clojure.core/list 'js/ReactNative.AlertIOS))))
