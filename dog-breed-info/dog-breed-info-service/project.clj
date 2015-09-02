(defproject dog-breed-info-service "0.1.0-SNAPSHOT"
  :description "Thrift service implementation for dog-breed-info"
  :url "http://github.com/samn/finagle-clojure-examples"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main dog-breed-info.service
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [dog-breed-info-core "0.1.0-SNAPSHOT"]
                 [finagle-clojure/thrift "0.4.1"]])
