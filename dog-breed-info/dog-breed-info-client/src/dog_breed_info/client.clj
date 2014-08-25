(ns dog-breed-info.client
  (:import [dog_breed_info.thrift DogBreedInfo BeautifulBreedRequest])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift]))

(defn make-client
  [address]
  (thrift/client address DogBreedInfo))

(defn beautiful?
  [client breed-name]
  (-> client
      (.isBeautiful (BeautifulBreedRequest. breed-name))
      (f/map [res] (.isBeautiful res))
      f/await))

(def client (make-client "localhost:9999"))

(beautiful? client "pit bull") ; => true
