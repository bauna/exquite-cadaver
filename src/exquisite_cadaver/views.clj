(ns exquisite_cadaver.views
  (:use [hiccup core page-helpers]))

(defn index-page []
  (html5
    [:head
      [:title "Hello World"]
      (include-css "/css/style.css")]
    [:body
      [:h1 "Hello World"]]))