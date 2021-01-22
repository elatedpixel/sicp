(ns sicp.chapter1.exercise3)

;; Exercise 1.3. Define a procedure that takes three numbers as arguments and
;; returns the sum of the squares of the two larger numbers.

(defn sum-of-squares [ns]
  "return the sum of squares of `ns`"
  (transduce (map #(* % %)) + 0 ns))

(defn n-largest-sum-of-squares [n & ns]
  "return the sum of squares of the `n` largest numbers"
  (sum-of-squares (take n (sort > ns))))

(comment
  (n-largest-sum-of-squares 2 23 56 71))
