(ns development
  (:require
   [mount.core :as mount]
   [com.fulcrologic.rad.attributes :as attr]
   [com.example.components.datomic :refer [datomic-connections]]))

(defn go []
  (mount/start-with-args {:config "config/dev.edn"}))

;; a way to quickly look up an attribute by its keyword
(def key->attribute (attr/attribute-map all-attributes))

;; to have a Form Validator that is based on the attribute definitions
;; that can be used in derived validators and directly on forms
(def default-validator (attr/make-attribute-validator all-attributes))

(comment
  (go))

