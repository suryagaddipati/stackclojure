(ns stackoverflow.common
   (import [ com.surya HttpClient] )
   (:use clojure.contrib.json))



(defn- query-param [x]
 (str  (name (first x) ) "=" (last x)) )

(defn query-string
  ([] "" )
  ( [x y]
   (str x "&" y)))

(defn get-json
  ([url] (get-json url {}) )
  ( [url params]
  ( let [qstr  (str url "?"  (reduce query-string (map query-param params)) ) ] 
    ;(print qstr)
   (read-json
   (HttpClient/getContent  qstr)))))


(defn stats []
 (first (:statistics 
   (get-json "http://api.stackoverflow.com/1.0/stats" ""))))