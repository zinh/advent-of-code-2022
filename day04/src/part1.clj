(ns part1)

(require '[common])

(defn process
  [filename]
  (let [lines (common/processInput filename)]
    (count (filter identity (map common/contained? (map common/parseLine lines))))
    ))
