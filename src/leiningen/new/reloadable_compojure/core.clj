(ns {{name}}.core
   (:use ring.adapter.jetty
         {{name}}.handler))

(defn start-server! []
  (defonce server
    (run-jetty #'app
               {:port 8080 :join? false}))
  (.start server))

(defn stop-server! []
  (.stop server))

(defn -main []
  (start-server!))

;; (start-server!)
