(ns stackoverflow.common
   (import [ com.surya HttpClient] )
   (:use clojure.contrib.json))


(defn get-json [url ]
  (read-json
  (HttpClient/getContent url)))

(defn stats []
 (first (:statistics 
   (get-json "http://api.stackoverflow.com/1.0/stats"))))