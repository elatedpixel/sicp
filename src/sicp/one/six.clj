(ns sicp.one.six)

;; Exercise 1.6. Alyssa P. Hacker doesn't see why if needs to be provided as a
;; special form. ``Why can't I just define it as an ordinary procedure in terms
;; of cond?'' she asks. Alyssa's friend Eva Lu Ator claims this can indeed be
;; done, and she defines a new version of if:

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else     else-clause))

;; Eva demonstrates the program for Alyssa:

(new-if (= 2 3) 0 5)
5

(new-if (= 1 1) 0 5)
0

;; Delighted, Alyssa uses new-if to rewrite the square-root program:

(defn average ^Double [x y]
  (double (/ (+ x y) 2)))

(defn improve ^Double [guess x]
  (average guess (double (/ x guess))))

(defn square ^Double [x] (* x x))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn sqrt-iter [^Double guess ^Double x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x) x)))

(sqrt-iter 13 50)

;; What happens when Alyssa attempts to use this to compute square roots? Explain.
