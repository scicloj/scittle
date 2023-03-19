(ns mathbox
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [mathbox.core :as mathbox]
            [mathbox.primitives :as mb]))

(defn Data []
  [mb/Interval
   {:expr (fn [emit x _i t]
            (emit x (Math/sin (+ x t))))
    :width 64
    :channels 2}])

(defn Curve []
  [:<>
   [Data]
   [mb/Line {:width 5
             :color "#3090FF"}]])

(defn main []
  [mathbox/MathBox
   {:container {:style {:height "400px" :width "100%"}}
    :focus 3}
   [mb/Camera {:position [0 0 3]
               :proxy true}]
   [mb/Cartesian
    {:range [[-2 2] [-1 1]]
     :scale [2 1]}

    [mb/Axis {:axis 1 :width 3 :color "black"}]
    [mb/Axis {:axis 2 :width 3 :color "black"}]
    [mb/Grid {:width 2 :divideX 20 :divideY 10}]
    [Curve]]])

(rdom/render [main] (.getElementById js/document "app"))
