(ns dog-breed-info.client-test
  (:require [dog-breed-info.client :refer :all]
            [clojure.test :refer :all]))

;; This requires a dog-breed-service running on localhost:9999
;; `lein run` in the dog-breed-service directory

(deftest test-beautful?
  (is (= true (beautiful? client "pit bull"))))

(deftest test-all-beautiful?
  (is (= false (all-beautiful? "pit bull" "lab" "pomeranian")))
  (is (= true (all-beautiful? "pit bull" "lab" "hound dog"))))
