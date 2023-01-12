(ns common)
(require '[clojure.string :as str])

(defn process-input
  [filename]
  (str/split (slurp filename) #"\n")
)
