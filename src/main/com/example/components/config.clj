(ns com.example.components.config
  (:require
   [com.fulcrologic.fulcro.server.config :as fulcro-config]
   [mount.core :refer [defstate args] :as mount]
   [taoensso.timbre :as log]))

(defstate config
  "The overrides option in args is for overriding configuration in
  tests."
  :start (let [{:keys [config overrides]
                :or {config "config/dev.edn"}} (args)
               loaded-config (merge (fulcro-config/load-config
                                     {:config-path config})
                                    overrides)]

           (log/info "Loading config" config)
           ;; set up Timbre to proper levels, etc...

           loaded-config))

