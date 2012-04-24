(ns exquisite_cadaver.db
  (:refer-clojure :exclude (find create))
  (:import (java.util Date)))

(defn to-keyword [num]
  (if-not (keyword? num)
    (keyword (str num))
    num))

(def counter (ref 0))

(defn random-number []
  (to-keyword 
    (dosync (alter counter inc))))

(def STORE (atom {}))

(defn addNew [attrs]
  (let [id (random-number)
        new-attrs (merge {:id id} attrs)]
    (swap! STORE merge {id new-attrs})
    new-attrs))

(defn find-all []
  (vals @STORE))

(defn find [id]
  ((to-keyword id) @STORE))

(defn update [id attrs]
  (let [updated-attrs (merge (find id) attrs)]
    (swap! STORE assoc (to-keyword id) updated-attrs)
    updated-attrs))

(defn delete [id]
  (let [old-attrs (find id)]
    (swap! STORE dissoc (to-keyword id))
    old-attrs))