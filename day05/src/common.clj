(ns common)

(require '[clojure.string :as str])

(defn parseLine
  "Parse line into column"
  [line]
  (map (comp clojure.string/trim clojure.string/join) (partition 4 4 nil line))
  )

(defn tranpose
  [lines]
  (let [l (count (first lines))]
    (reduce (fn [columns row] (map #(if (= %2 "") %1 (conj %1 %2)) columns row)) 
            (repeat l '()) 
            lines)
    )
  )

(defn parseCrates
  [[_firstLine & lines]]
  (map parseLine lines)
  )

(defn parseSteps
  [[_firstLine & lines]]
  (map #(map (fn [s] (Integer. s)) (rest (re-matches #"move (\d+) from (\d+) to (\d+)" %))) lines)
  )

(defn processInput
  [filename]
  (let [lines (str/split (slurp filename) #"\n")
        first-half ((comp parseCrates reverse) (take-while (partial not= "") lines))
        second-half (parseSteps (take-last (- (count lines) (count first-half) 1) lines))
    ]
    (list (tranpose first-half) second-half)
  ))
