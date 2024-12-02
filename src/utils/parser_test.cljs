(ns utils.parser-test
  (:require [clojure.test :refer [deftest testing is]]
            [utils.parser :as parser]))

(deftest parse-number-pairs-test
  (testing "Empty input"
    (is (= [] (parser/parse-number-pairs "")))
    (is (= [] (parser/parse-number-pairs "\n"))))

  (testing "Single pair"
    (is (= [[1 2]]
           (parser/parse-number-pairs "1 2")))
    (is (= [[10 20]]
           (parser/parse-number-pairs "10 20"))))

  (testing "Multiple pairs"
    (is (= [[1 2]
            [3 4]
            [5 6]]
           (parser/parse-number-pairs "1 2\n3 4\n5 6"))))

  (testing "Handles extra whitespace"
    (is (= [[1 2]]
           (parser/parse-number-pairs "  1   2  ")))
    (is (= [[1 2]
            [3 4]]
           (parser/parse-number-pairs "  1   2  \n  3   4  "))))

  (testing "Negative numbers"
    (is (= [[-1 2]
            [3 -4]]
           (parser/parse-number-pairs "-1 2\n3 -4"))))

  (testing "Zero values"
    (is (= [[0 0]]
           (parser/parse-number-pairs "0 0")))))
