(ns part1)

(require '[clojure.string :as str])

(defn sum
  [line]
  (reduce (fn [total item] (+ total (Integer. item))) 0 (str/split line #"\n")))

(defn process
  [filename]
  (map sum (str/split (slurp filename) #"\n\n")))

(defn sumTopN
  [filename n]
  (reduce + (take n (reverse (sort (map sum (str/split (slurp filename) #"\n\n")))))))
