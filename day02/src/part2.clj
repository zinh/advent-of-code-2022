(ns part2)
(require '[common])

(def choose-strategy
  {"X" {"A" "Z" "B" "X" "C" "Y"}
   "Y" {"A" "X" "B" "Y" "C" "Z"}
   "Z" {"A" "Y" "B" "Z" "C" "X"}})

(defn get-score
  [op outcome]
  (let [strategy (get-in choose-strategy [outcome op])]
    (common/calculate-score op strategy)))

(defn total-score
  [filename]
  (let [rounds (common/process-input filename)]
    (reduce + (map (fn [[op outcome]] (get-score op outcome)) rounds))))
