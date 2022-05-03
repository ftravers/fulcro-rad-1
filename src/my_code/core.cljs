(ns my-code.core
  (:require
   [reagent.dom :as rdom]
   [goog.dom :as gdom]))

(rdom/render [:p "Hello World!!!"]
             (gdom/getElement "app"))
