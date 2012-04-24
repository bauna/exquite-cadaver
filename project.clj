(defproject exquisite-cadaver "1.0.0-SNAPSHOT"
	:description "Exquisite Cadaver @ Twitter"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [compojure "1.0.0"]
                 [hiccup "0.3.7"]
                 [clj-json "0.5.0"]
                 [ring-json-params "0.1.3"]
                 [clojure-twitter "1.2.6-SNAPSHOT"]]
  :dev-dependencies [[lein-ring "0.5.0"]
                     [lein-eclipse "1.0.0"]]
  :ring {:handler exquisite_cadaver.routes/app})
