(defproject component-service "0.1.0-SNAPSHOT"
  :description "Thrift service implementation for component"
  :url "https://github.com/samn/finagle-clojure-examples/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main component.service
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [component-core "0.1.0-SNAPSHOT"]
                 [finagle-clojure/thrift "0.5.0"]
                 [com.stuartsierra/component "0.3.1"]])
