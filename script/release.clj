#!/usr/bin/env bb

(require '[babashka.fs :as fs]
         '[babashka.tasks :refer [shell]])

(fs/create-dirs "docs")

(fs/copy "resources/public/index.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/base.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/tictactoe.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/bookmarklet.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/wordle.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/disable_auto_eval.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/codemirror.html" "docs"
         {:replace-existing true})

(fs/copy "resources/public/mathbox.html" "docs"
         {:replace-existing true})

(def html-source-dir (fs/file "resources" "public" "html"))
(def html-target-dir (fs/file "docs" "html"))
(fs/create-dirs html-target-dir)
(doseq [html ["export.html" "reagent.html" "cljs-ajax.html"]]
  (fs/copy (fs/file html-source-dir html) html-target-dir
           {:replace-existing true}))

(def style-source-dir (fs/file "resources" "public" "css"))
(def style-target-dir (fs/file "docs" "css"))
(fs/create-dirs style-target-dir)
(fs/copy "resources/public/css/style.css" style-target-dir
         {:replace-existing true})

(def js-source-dir (fs/file "resources" "public" "js"))
(def js-target-dir (fs/file "docs" "js"))
(fs/create-dirs js-target-dir)

(println "Compiling CLJS")
(shell "bb prod")

(fs/copy "resources/public/js/report.html" "docs"
         {:replace-existing true})

(def index-file (fs/file "docs" "index.html"))

(def cljs-source-dir (fs/file "resources" "public" "cljs"))
(def cljs-target-dir (fs/file "docs" "cljs"))
(fs/create-dirs cljs-target-dir)

(run! (fn [f]
        (println "Copying" (str f))
        (fs/copy f
                 cljs-target-dir
                 {:replace-existing true}))
      (fs/glob cljs-source-dir "*.cljs"))

(run! (fn [f]
        (println "Copying" (str f))
        (fs/copy f
                 js-target-dir
                 {:replace-existing true}))
      (fs/glob js-source-dir "scittle*.js"))

(def with-docs (partial shell {:dir "docs"}))
;; (with-docs "git add .")
;; (with-docs "git commit -m 'update build'")
;; (with-docs "git push origin docs")

nil
