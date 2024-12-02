(ns adventofcode.y2024.d01.puzzle2-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [adventofcode.y2024.d01.puzzle2 :refer [count-occurrences similarity-score solve-part2]]
            ["fs" :as fs]
            ["path" :as path]))

(deftest count-occurrences-test
  (testing "Basic counting scenarios"
    (is (= 0 (count-occurrences 5 []))
        "Empty sequence should return 0")

    (is (= 0 (count-occurrences 5 [1 2 3 4]))
        "Number not in sequence should return 0")

    (is (= 1 (count-occurrences 5 [5]))
        "Single occurrence should return 1")

    (is (= 3 (count-occurrences 5 [5 5 5]))
        "Multiple consecutive occurrences")

    (is (= 3 (count-occurrences 5 [1 5 2 5 3 5]))
        "Multiple scattered occurrences"))

  (testing "Edge cases"
    (is (= 0 (count-occurrences nil []))
        "Nil number with empty sequence")

    (is (= 1 (count-occurrences 0 [0]))
        "Zero as the target number")

    (is (= 2 (count-occurrences -1 [-1 2 -1]))
        "Negative numbers"))

  (testing "Large sequences"
    (let [large-seq (concat (repeat 1000 5) (repeat 1000 6))]
      (is (= 1000 (count-occurrences 5 large-seq))
          "Large sequence with many occurrences"))))

;; (def example-input
;;   "3   4
;; 4   3
;; 2   5
;; 1   3
;; 3   9
;; 3   3")

;; (defn read-input []
;;   (fs/readFileSync
;;     (path/resolve "src" "adventofcode" "y2024" "d01" "input.txt")
;;     "utf-8"))

;; (deftest similarity-score-test
;;   (testing "calculates correct similarity score for examples"
;;     (is (= 9 (similarity-score [3] [3 3 3])))
;;     (is (= 4 (similarity-score [4] [3])))
;;     (is (= 0 (similarity-score [2] [5])))
;;     (is (= 9 (similarity-score [3] [3 3 3])))))

;; (deftest solve-part2-test
;;   (testing "solves example case correctly"
;;     (is (= 31 (solve-part2 example-input))))

;;   (testing "solves actual input"
;;     ;; Replace 12345 with your actual answer once you have it
;;     (is (= 12345 (solve-part2 (read-input))))))
