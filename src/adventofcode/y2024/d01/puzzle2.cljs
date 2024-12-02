(ns adventofcode.y2024.d01.puzzle2
  (:require [adventofcode.y2024.d01.puzzle1 :as puzzle1])
            [utils.parser :as parser])

(defn count-occurrences
  "Count how many times a number appears in a sequence"
  [num numbers]
  (count (filter #(= num %) numbers)))

(defn similarity-score
  "Calculate similarity score between two lists of numbers"
  [left-nums right-nums]
  (->> left-nums
       (map (fn [num]
              (* num (count-occurrences num right-nums))))
       (reduce +)))

(defn solve-part2 [input]
  (let [pairs (puzzle1/parser input)
        left-nums (map first pairs)
        right-nums (map second pairs)]
    (similarity-score left-nums right-nums)))
