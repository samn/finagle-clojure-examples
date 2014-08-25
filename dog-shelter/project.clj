(defproject dog-shelter "0.1.0-SNAPSHOT"
  :description "meta-project for dog-shelter. Run lein sub install to build all modules"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-sub "0.3.0"]]
  :sub ["dog-shelter-core" "dog-shelter-service" "dog-shelter-client"]
  :dependencies [
                ])
