(ns part1)
(require '[common])

(defn total-score
  [filename]
  (let [rounds (common/process-input filename)]
    (reduce + (map #(common/calculate-score (get % 0) (get % 1)) rounds))))
