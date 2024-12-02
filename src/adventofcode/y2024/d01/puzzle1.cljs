(ns adventofcode.y2024.d01.puzzle1
  (:require [clojure.string :as str]
            [utils.parser :as parser]))

(defn pair-and-distance [left-list right-list]
  (let [sorted-left (sort left-list)
        sorted-right (sort right-list)]
    (->> (map vector sorted-left sorted-right)
         (map (fn [[a b]] (Math/abs (- a b))))
         (reduce +))))

(defn solve-part1 [input]
  (let [pairs (parser input)
        left-nums (map first pairs)
        right-nums (map second pairs)]
    (pair-and-distance left-nums right-nums)))
