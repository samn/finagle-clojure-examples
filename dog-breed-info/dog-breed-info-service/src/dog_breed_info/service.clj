(ns dog-breed-info.service
  (:import [dog_breed_info.thrift DogBreedInfo BeautifulBreedRequest BeautifulBreedResponse])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift])
  (:gen-class))

(defn make-service
  []
  (thrift/service DogBreedInfo
    (isBeautiful [request]
      (let [breed-name (.getName request)]
        (if (= breed-name "pomeranian")
          (f/value (BeautifulBreedResponse. breed-name false))
          (f/value (BeautifulBreedResponse. breed-name true)))))))

(defn -main
  [& args]
  (f/await (thrift/serve ":9999" (make-service))))
