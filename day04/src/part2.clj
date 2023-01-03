(ns part2)

(require '[common])

(defn process
  [filename]
  (let [lines (common/processInput filename)]
    (count (filter identity (map common/overlapped? (map common/parseLine lines))))
    ))
