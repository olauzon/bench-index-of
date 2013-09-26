(defproject bench-index-of "0.1.0-SNAPSHOT"
  :description "Benchmark comparison of .indexOf"
  :url "https://github.com/olauzon/bench-index-of"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main bench-index-of.core
  :global-vars { *warn-on-reflection* true }
  :aot :all)
