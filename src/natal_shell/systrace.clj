(ns
 natal-shell.systrace
 "This namespace is automatically generated from the React Native docs.")
(clojure.core/defmacro
 set-enabled
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.setEnabled)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 begin-event
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.beginEvent)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 end-event
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.endEvent)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 begin-async-event
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.beginAsyncEvent)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 end-async-event
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.endAsyncEvent)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 counter-event
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.counterEvent)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 attach-to-relay-profiler
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.attachToRelayProfiler)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 swizzle-json
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.swizzleJSON)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 measure-methods
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.measureMethods)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
(clojure.core/defmacro
 measure
 [& args]
 (clojure.core/seq
  (clojure.core/concat
   (clojure.core/list '.measure)
   (clojure.core/list 'js/ReactNative.Systrace)
   args)))
