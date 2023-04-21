(ns scittle.emmy
  (:require
   [sci.core :as sci]
   [scittle.core :as scittle]
   [emmy.env :as emmy]
   [reagent.core :as reagent]))

(def emmy-namespace
  (sci/copy-ns emmy.env
               (sci/create-ns 'emmy.env nil)))

(scittle/register-plugin!
 ::mathbox
 {:namespaces
  {'emmy.env emmy-namespace}})
