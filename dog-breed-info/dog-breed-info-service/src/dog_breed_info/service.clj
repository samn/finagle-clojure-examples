(ns dog-breed-info.service
  (:import [dog_breed_info.thrift DogBreedInfo])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift])
  (:gen-class))

(defn make-service
  []
  (thrift/service DogBreedInfo
    ;; TODO implement service methods
    ))

(defn -main
  [& args]
  (f/await (thrift/serve ":9999" (make-service))))
