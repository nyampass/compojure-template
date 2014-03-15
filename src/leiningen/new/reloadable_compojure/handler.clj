(ns {{name}}.handler
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all])
  (:use ring.middleware.reload
        ring.middleware.stacktrace))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> app-routes
    handler/site
    (wrap-reload '({{name}}.core))
    (wrap-stacktrace)))
