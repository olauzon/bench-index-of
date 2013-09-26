(ns bench-index-of.core)

(def clj-vec
  ["Lorem"
   "ipsum"
   "dolor"
   "sit"
   "amet"
   "test-string"
   "consectetur"
   "adipiscing"
   "elit"
   "Maecenas"
   "pharetra"])

(def java-al
  (java.util.ArrayList.
    ["Lorem"
     "ipsum"
     "dolor"
     "sit"
     "amet"
     "test-string"
     "consectetur"
     "adipiscing"
     "elit"
     "Maecenas"
     "pharetra"]))

(defn index-of
  [coll el]
  (.indexOf coll el))

(def index-of-memo
  (memoize index-of))

(defn string-index-of
  [array-list ^String d]
  (.indexOf ^java.util.ArrayList array-list d))

(def string-index-of-memo
  (memoize string-index-of))

(def upto
  999999) ;; 1M

(defn run!
  []
  (do
    (println "")
    (println (str "Running 1M tests with each method:"))
    (println "")
    (println "(.indexOf clj-vec \"test-string\")")
    (time (dotimes [n upto] (.indexOf             clj-vec "test-string")))
    (println "")
    (println "(index-of clj-vec \"test-string\")")
    (time (dotimes [n upto] (index-of             clj-vec "test-string")))
    (println "")
    (println "(index-of-memo clj-vec \"test-string\")")
    (time (dotimes [n upto] (index-of-memo        clj-vec "test-string")))
    (println "")
    (println "(string-index-of java-al \"test-string\")")
    (time (dotimes [n upto] (string-index-of      java-al "test-string")))
    (println "")
    (println "(string-index-of-memo java-al \"test-string\")")
    (time (dotimes [n upto] (string-index-of-memo java-al "test-string")))
    (println "")))

(defn -main
  []
  run!)
