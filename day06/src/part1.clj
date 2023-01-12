(ns part1)
(require '[common])

(defn process-list
  [[[idx c] & r] memo]
  (if (common/duplicated? (conj memo c))
    (if (empty? r)
      nil
      (process-list r (subvec (conj memo c) 1))
      )
    (+ idx 1)
    )
  )

(let [lst (into [] (common/process-file "4.input"))
      target-list (subvec lst 13)
      memo (into [] (map #(nth % 1) (take 13 lst)))
      ]
  (println (process-list target-list memo))
  )
