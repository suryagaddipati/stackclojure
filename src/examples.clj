(ns examples
  (:use stackoverflow.questions))

;take top 2 favorited questions
(take 2 (filter  #(> (:favorite_count %) 0) questions))