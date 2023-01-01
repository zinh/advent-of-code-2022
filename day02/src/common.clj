(ns common)
(require '[clojure.string :as str])

(def scores {"X" 1
             "Y" 2
             "Z" 3})

(def win-table {"X" {"A" 3 "B" 0 "C" 6}
                "Y" {"A" 6 "B" 3 "C" 0}
                "Z" {"A" 0 "B" 6 "C" 3}})

(defn process-input
  [filename]
  (map #(str/split % #" ") (str/split (slurp filename) #"\n")))

(defn calculate-score
  [op self]
  (let [result (get-in win-table [self op])
        score (scores self)]
    (+ result score)))
