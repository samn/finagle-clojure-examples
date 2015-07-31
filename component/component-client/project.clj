(defproject component-client "0.1.0-SNAPSHOT"
  :description "Thrift client for component"
  :url "https://github.com/samn/finagle-clojure-examples/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.7.0"]]}}
  :main component.client
  :dependencies [[component-core "0.1.0-SNAPSHOT"]
                 [finagle-clojure/thrift "0.4.0"]
                 [com.stuartsierra/component "0.2.3"]])
