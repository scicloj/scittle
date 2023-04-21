(ns scittle.tmdjs
  (:require
   [sci.core :as sci]
   [scittle.core :as scittle]
   [tech.v3.dataset]
   [reagent.core :as reagent]))

(def tmd-namespace
  (sci/copy-ns tech.v3.dataset
               (sci/create-ns 'tech.v3.dataset nil)))

(scittle/register-plugin!
 ::mathbox
 {:namespaces
  {'tech.v3.dataset tmd-namespace}})
