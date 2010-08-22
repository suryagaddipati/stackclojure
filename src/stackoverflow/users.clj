(ns stackoverflow.users
  (:use stackoverflow.common))

(def *moderators-url* "http://api.stackoverflow.com/1.0/users/moderators")

(defn moderators []
 (get-json *moderators-url*) )
