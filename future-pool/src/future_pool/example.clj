(ns future-pool.example
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.future-pool :as fp])
  (:import [java.util.concurrent Executors]))

(def thread-pool (Executors/newCachedThreadPool))

(def future-pool (fp/future-pool thread-pool))

(defn slurp-async
  [file]
  (fp/run future-pool
    (slurp file)))

(slurp-async "README.md") ; => Future

(-> "README.md"
    slurp-async
    (f/map [contents]
      (.toLowerCase contents))
    (f/map [string]
      (frequencies string))
    f/await)
