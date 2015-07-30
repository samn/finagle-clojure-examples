(ns component.service
  (:gen-class)
  (:import [component.thrift Component])
  (:require [finagle-clojure.futures :as f]
            [finagle-clojure.thrift :as thrift]
            [finagle-clojure.builder.server :as server]
            [finagle-clojure.duration :as duration]
            [com.stuartsierra.component :as component]))

(defn make-service
  [greeting]
  (thrift/service Component
    (hello [] 
      (f/value greeting))))

(defrecord Server [port service]
  component/Lifecycle
  (start [this]
    (if (:server this)
      this
      (let [port (str ":" port)
            server (thrift/serve port service)]
        (println "Server started on" port)
        (assoc this :server server))))
  (stop [this]
    (if-not (:server this)
      this
      (do
        (println "Stopping server")
        (-> (:server this) (server/close!) (f/within 1 :s) (f/await))
        ;; dissoc'ing a required key from a record would make it a plain map
        (assoc this :server nil)))))

(defn make-system
  [config]
  (component/system-map
    :service (make-service (:greeting config))
    :server (-> (->Server (:port config) nil) (component/using [:service]))))

(defn -main
  [& args]
  (let [system (make-system {:greeting "hi" :port 9090})]
    (-> system
        (component/start)
        (get-in [:server :server])
        (f/await))))
