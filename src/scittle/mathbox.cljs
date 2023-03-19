(ns scittle.mathbox
  (:require
   [sci.core :as sci]
   [scittle.core :as scittle]
   [mathbox.core :as mathbox]
   [mathbox.primitives :as mb]
   [reagent.core :as reagent]))

(def mathbox-namespace
  (sci/copy-ns mathbox.core
               (sci/create-ns 'mathbox.core nil)))

(def mathbox-primitives-namespace
  (sci/copy-ns mathbox.primitives
               (sci/create-ns 'mathbox.primitives nil)))

(scittle/register-plugin!
 ::mathbox
 {:namespaces
  {'mathbox.core mathbox-namespace
   'mathbox.primitives mathbox-primitives-namespace}})
