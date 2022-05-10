(ns com.example.components.auto-resolvers
  (:require
   [com.example.model :refer [all-attributes]]
   [mount.core :refer [defstate]]
   [com.fulcrologic.rad.resolvers :as res]
   [taoensso.timbre :as log]))

(defstate automatic-resolvers
  :start
  (vec (res/generate-resolvers all-attributes))
