(ns part1)
(require '[common])

(defn runMove
  "Move n-row rows from from-col to to-col"
  [columns [n-row from-col to-col]]
  (let [col-from (nth columns (- from-col 1))
        col-to (nth columns (- to-col 1))
        col-from-new (take-last (- (count col-from) n-row) col-from)
        col-to-new (apply (partial conj col-to) (take n-row col-from))
        ]
    (map-indexed #(cond
                    (= %1 (- from-col 1)) col-from-new 
                    (= %1 (- to-col 1)) col-to-new 
                    :else %2
                    ) columns)
    )
  )

(defn main
  [filename]
  (let [[columns moves] (common/processInput filename)]
    (println (map first (reduce runMove columns moves)))
    )
  )

(main "2.input")
