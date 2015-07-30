(defproject component "0.1.0-SNAPSHOT"
  :description "meta-project for component. Run lein sub install to build all modules"
  :url "https://github.com/samn/finagle-clojure-examples/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-sub "0.3.0"]]
  :sub ["component-core" "component-service" "component-client"]
  :dependencies [
                ])
