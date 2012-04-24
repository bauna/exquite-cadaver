(ns exquisite_cadaver.routes
  (:use compojure.core
        exquisite_cadaver.views 
        [exquisite_cadaver.db :as db] 
        [clj-json.core :as json.db]
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [clj-json.core :as json]
            [compojure.response :as response]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(db/addNew {:one 1})
(db/addNew {:two 2})

(defroutes main-routes
  (GET "/tag" [] (json-response (db/find-all)))
  (GET "/tag/:id" [id] (json-response (db/find id)))
  (POST "/tag" {params :params}  (json-response (db/addNew params)))
  (PUT "/tag/:id" {params :params} (json-response (db/update (params "id")  params)))
  (DELETE "/tag/:id" [id] (json-response (db/delete id )))
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
