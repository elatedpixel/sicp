(ns sicp.one.three)

;; Exercise 1.3. Define a procedure that takes three numbers as arguments and
;; returns the sum of the squares of the two larger numbers.

(defn sum-of-squares [ns]
  "return the sum of squares of `ns`"
  (transduce (map #(* % %)) + 0 ns))

(defn exercise-1-3 [x y z]
  "a procedure that takes three numbers as arguments and returns the sum of the
 squares of the two larger numbers"
  (sum-of-squares [x y z]))

(comment
  (exercise-1-3 37521 48723 55234)
  ;; => 6832550926
  )
