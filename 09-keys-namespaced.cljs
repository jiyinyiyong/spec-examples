
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::age number?)

(s/def ::name string?)

(s/def ::example (s/keys :req [::age] :opt [::name]))

(let [data {::age 1, ::name "a"}]
  (if (s/valid? ::example data)
    (println (s/conform ::example data))
    (println (expound ::example data))))
