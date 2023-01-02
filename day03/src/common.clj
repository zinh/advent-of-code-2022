(ns common)

(require '[clojure.string :as str])
(require '[clojure.set :as setOp])

(defn processInput
  [filename]
  (str/split (slurp filename) #"\n"))

(defn getPriority
  [chr]
  (let [codePoint (int chr)]
    (if (>= codePoint (int \a))
      (+ 1 (- codePoint (int \a)))
      (+ 27 (- codePoint (int \A))))))

(defn calculateScore
  [line]
  (let [l (count line)
        firstHalf (take (/ l 2) line)
        secondHalf (take-last (/ l 2) line)
        ]
    (getPriority (first (setOp/intersection (set firstHalf) (set secondHalf))))
    )
  )
