(ns emmy
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [emmy.env :refer :all]))

(defn main []
  [:div
   [:pre
    [:code
     (pr-str
      '(-> ((D cube) 'x)
           simplify
           ->infix))]]
   (-> ((D cube) 'x)
       simplify
       ->infix)])


(rdom/render [main] (.getElementById js/document "app"))
