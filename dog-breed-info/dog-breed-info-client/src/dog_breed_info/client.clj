(ns dog-breed-info.client
  (:import [dog_breed_info.thrift DogBreedInfo Request])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift]))

(defn make-client
  [address]
  (thrift/client address DogBreedInfo))

(def client (make-client "localhost:9999"))

(defn beautiful?
  [client breed-name]
  ;; make a request
  (-> (.isBreedBeautiful client (Request. breed-name))
      ;; extract the beautiful boolean from the Response object
      (f/map [res] (.isBeautiful res))
      f/await))

(comment 
  (beautiful? client "pit bull") ; => true
)

(defn all-beautiful?
  [& breeds]
  ;; request breed info in parallel
  (-> (map #(.isBreedBeautiful client (Request. %)) breeds)
      ;; coalesce the futures of the above requests into one future
      ;; of a seq of their response values
      f/collect
      ;; transform the result of the isBreedBeautiful requests
      (f/map [responses]
        (->> responses
             (map #(.isBeautiful %))
             (every? true?)))
      f/await))

(comment 
  (all-beautiful? "pit bull" "lab" "pomeranian") ; => false
  (all-beautiful? "pit bull" "lab" "hound dog") ; => true

  (-> (f/exception (Exception.))
      ;; transform the error into a successful future
      (f/handle [t] 0)
      ;; handle a successful response
      (f/map [v] (inc v))
      f/await) ; => 1
  )
