(ns common)

(require '[clojure.string :as str])

(defn processInput
  [filename]
  (let [lines (str/split (slurp filename) #"\n")
        first-half (take-while (partial not= "") lines)
        second-half (take-last (- (count lines) (count first-half) 1) lines)
    ]
    (list first-half second-half)
  ))

(defn parseCrates
  [lines]
  ()
  )

(defn parseSteps
  [lines]
  ()
  )
