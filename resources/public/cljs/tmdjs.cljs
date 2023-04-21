(ns tmdjs
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [tech.v3.dataset :as dataset]))

(defn main []
  [:div
   [:pre
    [:code (pr-str
            '(-> {:x [1 2 3]}
                 dataset/->dataset
                 :x
                 pr-str))]]
   (-> {:x [1 2 3]}
       dataset/->dataset
       :x
       pr-str)])

(rdom/render [main] (.getElementById js/document "app"))
