(ns com.example.model
  (:require
   [com.example.model.account :as account]
   [com.fulcrologic.rad.attributes :as attr]))

;; normally you'd have more of these attributes
(def all-attributes account/attributes)
