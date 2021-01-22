(ns sicp.one.four
  (:require [clojure.test :as test]))

;; Exercise 1.4. Observe that our model of evaluation allows for combinations
;; whose operators are compound expressions. Use this observation to describe
;; the behavior of the following procedure:

(test/with-test

  (defn a-plus-abs-b [a b]
    "returns `a` + the absolute value of `b`"
    ((if (pos? b) + -) a b))

  (test/are [a b expected] (= expected (a-plus-abs-b a b))
    7 0 7
    7 1 8
    7 -1 8)
  )

(test/run-tests 'sicp.one.four)
