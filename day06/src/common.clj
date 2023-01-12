(ns common)
(require '[clojure.string :as str])

(defn process-file
  [filename]
  (map-indexed list
               (drop-last (str/split (slurp filename) #"")))
  )

(defn duplicated?
  [lst]
  (not= (count lst) (count (set lst)))
  )
