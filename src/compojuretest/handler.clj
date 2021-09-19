(ns compojuretest.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clj-http.client :as client]))

(defroutes app-routes
  (GET "/" [] (client/get "https://rickandmortyapi.com/api/character/232"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
