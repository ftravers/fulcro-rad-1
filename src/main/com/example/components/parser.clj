(ns com.example.components.parser
  (:require
   [com.example.components.auto-resolvers :refer [automatic-resolvers]]
   [com.example.components.config :refer [config]]
   [com.example.components.datomic :refer [datomic-connections]]
   [com.example.components.middleware :as middleware]
   [com.example.model :refer [all-attributes]]
   [com.example.model.account :as account]
   [com.fulcrologic.rad.attributes :as attr]
   [com.fulcrologic.rad.blob :as blob]
   [com.fulcrologic.rad.database-adapters.datomic :as datomic]
   [com.fulcrologic.rad.form :as form]
   [com.fulcrologic.rad.pathom :as pathom]
   [mount.core :refer [defstate]]))

(defstate parser
  :start
  (pathom/new-parser config
    [(attr/pathom-plugin all-attributes) ; required to populate standard things in the parsing env
     (form/pathom-plugin save/middleware delete/middleware) ; installs form save/delete middleware
     (datomic/pathom-plugin (fn [env] {:production (:main datomic-connections)})) ; db-specific adapter
    [automatic-resolvers ; the resolvers generated from attributes
     form/resolvers      ; predefined resolvers for form support (save/delete)
     account/resolvers   ; custom resolvers you wrote, etc.
     ])))
