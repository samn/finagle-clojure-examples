(defproject dog-breed-info-client "0.1.0-SNAPSHOT"
  :description "Thrift client for dog-breed-info"
  :url "http://github.com/samn/finagle-clojure-examples"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]]}}
  :dependencies [[dog-breed-info-core "0.1.0-SNAPSHOT"]
                 [finagle-clojure/thrift "0.6.0"]])
