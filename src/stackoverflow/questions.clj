(ns stackoverflow.questions
  (:use stackoverflow.common))

(def *question-page-url* "http://api.stackoverflow.com/1.0/questions?pagesize=1&page=%s" )

(def *q-answers-url* "http://api.stackoverflow.com/1.0/questions/%s/answers" )

(defn question-answers [id]
 (do ;(print "** in  answers") 
  (:answers (get-json (format *q-answers-url* id ) ) )))

(defn question [page-num]
  ( let [ question-result
    (first  (:questions 
      (get-json (format *question-page-url* page-num))))]
  (merge {:answers (delay 
                     (question-answers  (:question_id question-result))) } question-result )))

(defn question-seq
  ([] (question-seq 1)) ;start from page 1
  ( [x]
  (lazy-seq  (cons (question x)  (question-seq  ( inc x)) ) ) ))

(def questions (question-seq))


 