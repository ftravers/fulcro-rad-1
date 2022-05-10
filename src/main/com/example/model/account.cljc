(ns com.example.model.account
  (:require
   [com.fulcrologic.rad.attributes-options :as ao]
   [com.fulcrologic.rad.attributes :refer [defattr]]))

(defattr id :account/id :uuid
  {ao/identity? true})

(defattr name :account/name :string
  {ao/required? true
   ao/identities #{:account/id}})

(def attributes [id name])
(def resolvers [])
