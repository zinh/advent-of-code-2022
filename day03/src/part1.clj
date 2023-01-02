(ns part1)

(require '[common])

(defn process
  [filename]
  (let [lines (common/processInput filename)]
    (reduce + (map common/calculateScore lines))
    ))
