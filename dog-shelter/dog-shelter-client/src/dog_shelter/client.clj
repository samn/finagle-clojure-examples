(ns dog-shelter.client
  (:import [dog_shelter.thrift DogShelter])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift]))

(defn make-client
  [address]
  (thrift/client address DogShelter))
