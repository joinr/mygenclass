(ns mygenclass.Demo
  (:require [mygenclass.genclass]))

(gen-class
 :name mygenclass.Demo
 :methods [[sum [^{java.lang.Deprecated true
                   :tag "[J"} obj] long]
           [prod [^{java.lang.Deprecated true
                   :tag longs} obj] long]
           [bar [^{java.lang.Deprecated true
                   :tag "[Ljava.lang.Object;"} obj] void]])

(defn -sum ^long [this ^longs xs]
  (areduce xs idx acc 0 (+ acc (aget xs idx))))

(defn -prod ^long [this ^longs xs]
  (areduce xs idx acc 0 (* acc (aget xs idx))))

(defn -bar [this  ^objects xs]
  (println [(type xs) xs]))
