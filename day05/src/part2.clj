(ns part2)
(require '[common])

(defn replace-by
  "Replace item at position pos by new-item"
  [pos new-item coll]
  (map-indexed #(if (= pos %1) new-item %2) coll)
  )

(defn runMove
  "Move n-row rows from from-col to to-col"
  [columns [n-row from-col to-col]]
  (let [col-from (nth columns (- from-col 1))
        col-to (nth columns (- to-col 1))
        col-from-new (take-last (- (count col-from) n-row) col-from)
        col-to-new (apply (partial conj col-to) (reverse (take n-row col-from)))
        ]
    (replace-by (- to-col 1) col-to-new (replace-by (- from-col 1) col-from-new columns))
    )
  )

(defn main
  [filename]
  (let [[columns moves] (common/processInput filename)]
    (println (map first (reduce runMove columns moves)))
    )
  )

(main "2.input")
