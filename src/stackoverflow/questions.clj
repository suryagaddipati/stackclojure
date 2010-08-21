(ns stackoverflow.questions
  (:use stackoverflow.common))

(defn question [page-num]
(do ;(println (str "Page-NUM :" page-num)) 
  (first  (:questions 
   (get-json (str "http://api.stackoverflow.com/1.0/questions?pagesize=1&page=" page-num))))))

(defn question-seq
  ([] (question-seq 1)) ;start from page 1
  ( [x]
  (lazy-seq  (cons (question x)  (question-seq  ( inc x)) ) ) ))

(def questions (question-seq))


 