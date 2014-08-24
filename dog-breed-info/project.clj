(defproject dog-breed-info "0.1.0-SNAPSHOT"
  :description "meta-project for dog-breed-info. Run lein sub install to build all modules"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-sub "0.3.0"]]
  :sub ["dog-breed-info-core" "dog-breed-info-service" "dog-breed-info-client"]
  :dependencies [
                ])
