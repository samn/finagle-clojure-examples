(defproject dog-breed-info-core "0.1.0-SNAPSHOT"
  :description "Core data types & service definition for dog-breed-info"
  :url "http://github.com/samn/finagle-clojure-examples"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-finagle-clojure "0.4.0"]]
  :java-source-paths ["src/java"]
  :repositories [["twitter" {:url "https://maven.twttr.com/" :checksum :warn}]]
  :finagle-clojure {:thrift-output-path "src/java", :thrift-source-path "src/thrift"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [finagle-clojure/thrift "0.4.0"]
                 [com.twitter/scrooge-core_2.11 "3.20.0"]])
