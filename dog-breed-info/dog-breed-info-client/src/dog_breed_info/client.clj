(ns dog-breed-info.client
  (:import [dog_breed_info.thrift DogBreedInfo])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift]))

(defn make-client
  [address]
  (thrift/client address DogBreedInfo))
