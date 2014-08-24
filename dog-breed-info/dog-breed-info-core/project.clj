(defproject dog-breed-info-core "0.1.0-SNAPSHOT"
  :description "Core data types & service definition for dog-breed-info"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-finagle-clojure "0.1.0-SNAPSHOT"]]
  :java-source-paths ["src/java"]
  :repositories [["twitter" {:url "http://maven.twttr.com/", :checksum :warn}]]
  :finagle-clojure {:thrift-output-path "src/java", :thrift-source-path "src/thrift"}
  :dependencies [
                 [finagle-clojure/thrift "0.1.0-SNAPSHOT"]
                 [com.twitter/scrooge-core_2.10 "3.16.3"]
                ])
