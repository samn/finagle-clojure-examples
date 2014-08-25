(defproject dog-shelter-client "0.1.0-SNAPSHOT"
  :description "Thrift client for dog-shelter"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.6.0"]]}}
  :dependencies [
                 [dog-shelter-core "0.1.0-SNAPSHOT"]
                 [finagle-clojure/thrift "0.1.0-SNAPSHOT"]
                ])
