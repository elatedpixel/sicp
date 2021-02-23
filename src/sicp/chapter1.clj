(ns sicp.chapter1
  (:require [clojure.test :as t]))

;; 1.1
(comment
  ;; Below is a sequence of expressions. What is the result printed by the
  ;; interpreter in response to each expression? Assume that the sequence is to be
  ;; evaluated in the order in which it is presented.

  10
  (+ 5 3 4)
  (- 9 1)
  (/ 6 2)
  (+ (* 2 4) (- 4 6))
  (def ^:private a 3)
  (def b (+ a 1))
  (+ a b (* a b))
  (= a b)
  (if (and (> b a) (< b (* a b)))
    b
    a)
  (cond (= a 4) 6
        (= b 4) (+ 6 7 a)
        :else   25)
  (+ 2 (if (> b a) b a))
  (* (cond (> a b) a
           (< a b) b
           :else   -1)
     (+ a 1))
  ;; 16
  )

;; 1.2
(comment
  ;; Exercise 1.2 Translate the following expression into prefix form

  (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
     (* 3 (- 6 2) (- 2 7)))
  ;; => -37/150
  )

;; 1.3
(comment

;; Exercise 1.3. Define a procedure that takes three numbers as arguments and
;; returns the sum of the squares of the two larger numbers.

  (defn sum-of-squares
    "return the sum of squares of `ns`"
    [ns]
    (letfn [(square [n] (* n n))]
      (transduce (map square) + 0 ns)))

  (defn exercise-1-3
    "a procedure that takes three numbers as arguments and returns the sum of the
  squares of the two larger numbers"
    [x y z]
    (sum-of-squares [x y z]))

  (comment
    (exercise-1-3 37521 48723 55234)
  ;; => 6832550926
    ))

;; 1.4
(comment
  ;; Exercise 1.4. Observe that our model of evaluation allows for combinations
  ;; whose operators are compound expressions. Use this observation to describe
  ;; the behavior of the following procedure:

  (t/with-test

    (defn a-plus-abs-b
      "returns `a` + the absolute value of `b`"
      [a b]
      ((if (pos? b) + -) a b))

    (t/are [a b expected] (= expected (a-plus-abs-b a b))
      7 0 7
      7 1 8
      7 -1 8))

  (t/run-tests))

;; 1.5
(comment
;; Exercise 1.5 Ben Bitdiddle has invented a test to determine whether the
;; interpreter he is faced with is using applicative-order evaluation or
;; normal-order evaluation. He defines the following two procedures

  (defn p [] (p))

  (defn test [x y]
    (if (= x 0) 0 y))

  (test 0 (p))

  ;; normal-order will produce stack overflow because `(p)` is evaluated ad infinitum

  ;; applicative-order would just return 0
  )
