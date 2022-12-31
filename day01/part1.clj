(ns part1)

(require '[clojure.str :as str])


(defn sum
  [line]
  (reduce (fn [total item] (+ total (Integer. item))) 0 (str/split line #"\n"))
  )

(defn process
  [filename]
  (map sum (str/split (slurp filename) #"\n\n"))
  )
