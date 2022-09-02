(ns mygenclass.core
  (:require [mygenclass.Demo]))

(comment ;;repl testing..
  (require '[clojure.reflect :refer [reflect]])
  (compile 'mygenclass.Demo)
  (import 'mygenclass.Demo)
  ;;mygenclass.Demo
  (reflect mygenclass.Demo)
 ;;  {:bases #{java.lang.Object},
 ;; :flags #{:public},
 ;; :members
 ;; #{{:name hashCode__var,
 ;;    :type clojure.lang.Var,
 ;;    :declaring-class mygenclass.Demo,
 ;;    :flags #{:private :static :final}}
 ;;   {:name equals__var,
 ;;    :type clojure.lang.Var,
 ;;    :declaring-class mygenclass.Demo,
 ;;    :flags #{:private :static :final}}
 ;;   {:name equals,
 ;;    :return-type boolean,
 ;;    :declaring-class mygenclass.Demo,
 ;;    :parameter-types [java.lang.Object],
 ;;    :exception-types [],
 ;;    :flags #{:public}}
 ;; ...elided
 ;;   {:name mygenclass.Demo,
 ;;    :declaring-class mygenclass.Demo,
 ;;    :parameter-types [],
 ;;    :exception-types [],
 ;;    :flags #{:public}}
 ;;;;THIS IS OUR CUSTOM METHOD...
  ;; {:name sum,
  ;;  :return-type long,
  ;;  :declaring-class mygenclass.Demo,
  ;;  :parameter-types [java.lang.Long<>],
  ;;  :exception-types [],
  ;;  :flags #{:public}}
 ;;   {:name bar,
 ;;    :return-type void,
 ;;    :declaring-class mygenclass.Demo,
 ;;    :parameter-types [java.lang.Object<>],
 ;;    :exception-types [],
 ;;    :flags #{:public}}}}
 ;; {:name prod,
 ;; :return-type long,
 ;;  :declaring-class mygenclass.Demo,
 ;;  :parameter-types [long<>],
 ;;  :exception-types [],
 ;;  :flags #{:public}}

 ;;let's instantiate it..
  (def d (mygenclass.Demo.))
  ;;let's see if annotations exist...
  (for [meth (filter (fn [m] (#{"sum" "prod" "bar"} (.getName m))) (.getMethods Demo))]
    [meth   (.getParameterAnnotations meth)])
  ;; ([#object[java.lang.reflect.Method 0x6730a2f7 "public long mygenclass.Demo.sum(long[])"]
  ;;   [[#object[com.sun.proxy.$Proxy1 0x46f78ac2 "@java.lang.Deprecated()"]]]]
  ;;  [#object[java.lang.reflect.Method 0x341ec8d6 "public void mygenclass.Demo.bar(java.lang.Object[])"]
  ;;   [[#object[com.sun.proxy.$Proxy1 0x79f465d3 "@java.lang.Deprecated()"]]]]
  ;;  [#object[java.lang.reflect.Method 0x565e29a1 "public long mygenclass.Demo.prod(long[])"]
  ;;   [[#object[com.sun.proxy.$Proxy1 0x6b7913a2 "@java.lang.Deprecated()"]]]])
  )

