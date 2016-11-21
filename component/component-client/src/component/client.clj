(ns component.client
  (:gen-class)
  (:import [component.thrift Component])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift]
            [com.stuartsierra.component :as component]))

(defn make-client
  [address]
  (thrift/client address Component))

(defrecord ComponentClient [address]
  component/Lifecycle
  (start [this]
    (if (:client this)
      this
      (assoc this :client (make-client address))))
  (stop [this]
    (if-not (:client this)
      this
      (assoc this :client nil))))

(defn -main
  [& args]
  (let [client (component/start (->ComponentClient "localhost:9090"))]
    (println (f/await (.hello (:client client))))))
