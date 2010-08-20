(ns stackoverflow
   (import [ com.surya HttpClient] )
   (:use clojure.contrib.json))

(defn get-json [url ]
  (read-json
  (HttpClient/getContent url)))