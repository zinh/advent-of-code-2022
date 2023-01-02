(ns part2)

(require '[common])
(require '[clojure.set :as setOp])

(defn calculateScore
  [lines]
  (common/getPriority (first (apply setOp/intersection (map set lines))))
  )

(defn process
  [filename]
  (let [lines (partition 3 (common/processInput filename))]
    (reduce + (map calculateScore lines))
    ))
