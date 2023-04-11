(ns hello.main
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :refer [wrap-resource]]
            [clojure.tools.logging :as log]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(defn -main [& args]
  (log/info "starting server")
  (jetty/run-jetty
   (-> handler
       (wrap-resource "public"))
   {:port 3003
    :allow-null-path-info true
    :join? true}))

