(ns common)

(require '[clojure.string :as str])

(defn processInput
  [filename]
  (str/split (slurp filename) #"\n"))

(defn contained?
  "check if a is contained by b or vice versa"
  [[[a_start a_end] [b_start b_end]]]
  (or (and (>= a_start b_start) (<= a_end b_end))
      (and (<= a_start b_start) (>= a_end b_end))
      )
  )

(defn overlapped?
  [[[a_start a_end] [b_start b_end]]]
  (or (not (or (< a_end b_start) (> a_start b_end)))
      (not (or (< b_end a_start) (> b_start a_end)))
      )
   )

(defn parseLine
  "Parse a line into group of two pairs"
  [line]
  (map #(map read-string (str/split % #"-")) (str/split line #","))
  )
