(ns sicp.one.five)

;; Exercise 1.5 Ben Bitdiddle has invented a test to determine whether the
;; interpreter he is faced with is using applicative-order evaluation or
;; normal-order evaluation. He defines the following two procedures

(defn p [] (p))

(defn test [x y]
   (if (= x 0) 0 y))

(test 0 (p))

;; normal-order will produce stack overflow because `(p)` is evaluated ad infinitum

;; applicative-order would just return 0
