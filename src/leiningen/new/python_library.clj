(ns leiningen.new.python-library
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "python-library"))

(defn python-library
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' python-library project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE")]
             [".gitignore" (render "gitignore")]

             ["bin/prepare.sh" (render "bin/prepare.sh") :executable true]
             ["bin/test.sh" (render "bin/test.sh") :executable true]
             ["bin/build-dist.sh" (render "bin/build-dist.sh") :executable true]

             ["setup.py" (render "setup.py" data )]
             ["{{sanitized}}/__init__.py" (render "library/__init__.py")]
             ["tests/__init__.py" (render "tests/__init__.py")]
             ["tests/test_sample.py" (render "tests/test_sample.py")])))
