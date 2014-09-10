(ns dog-breed-info.service
  (:import [dog_breed_info.thrift DogBreedInfo Request Response])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift])
  (:gen-class))

(defn make-service
  []
  (thrift/service DogBreedInfo
    (isBreedBeautiful [^Request request]
      (let [breed-name (.getName request)
            beautiful (not= breed-name "pomeranian")]
        (f/value (Response. breed-name beautiful))))))

(defn -main
  [& args]
  (f/await (thrift/serve ":9999" (make-service))))
