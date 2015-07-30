(defproject component-core "0.1.0-SNAPSHOT"
  :description "Core data types & service definition for component"
  :url "https://github.com/samn/finagle-clojure-examples/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-finagle-clojure "0.3.0"]]
  :java-source-paths ["src/java"]
  :finagle-clojure {:thrift-output-path "src/java", :thrift-source-path "src/thrift"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.6.0"]]}}
  :dependencies [[finagle-clojure/thrift "0.3.0"]
                 [com.twitter/scrooge-core_2.10 "3.16.3"]])
