(ns utils.parser
  (:require [clojure.string :as str]))

(defn parse-number-pairs
  "Parse input string into pairs of numbers.
   Each line is expected to contain two numbers separated by whitespace."
  [input]
  (->> (str/split-lines input)
       (map (fn [line]
              (let [[left right] (str/split (str/trim line) #"\s+")]
                [(parse-long left) (parse-long right)])))))
