(ns adventofcode.y2024.d01.puzzle1-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [adventofcode.y2024.d01.puzzle1 :as puzzle1]
            ["fs" :as fs]
            ["path" :as path]))

(def example-input
  "3   4
4   3
2   5
1   3
3   9
3   3")

(defn read-input []
  (fs/readFileSync
   (path/resolve "src" "adventofcode" "y2024" "d01" "input.txt")
   "utf-8"))

(deftest solve-part1-test
  (testing "solves example case correctly"
    (is (= 11 (puzzle1/solve-part1 example-input))))

  (testing "solves actual input"
    (is (= 1882714 (puzzle1/solve-part1 (read-input))))))
