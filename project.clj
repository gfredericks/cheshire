(defproject cheshire "5.0.0"
  :description "JSON and JSON SMILE encoding, fast."
  :url "https://github.com/dakrone/cheshire"
  :license {:name "The Apache License"
            :url "https://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}
  :warn-on-reflection false
  :dependencies [[com.fasterxml.jackson.core/jackson-core "2.1.1"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-smile "2.1.1"]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.4.0"]
                                  [criterium "0.3.0"]
                                  [org.clojure/test.generative "0.1.4"]
                                  [org.clojure/data.json "0.2.0"]
                                  [clj-json "0.5.0"]]}
             :1.2 {:dependencies [[org.clojure/clojure "1.2.1"]]}
             :1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.0-beta1"]]}}
  :aliases {"all" ["with-profile" "dev,1.2:dev,1.3:dev:dev,1.5"]}
  :test-selectors {:default  #(and (not (:benchmark %))
                                   (not (:generative %)))
                   :benchmark :benchmark
                   :generative :generative
                   :all (constantly true)}
  :jvm-opts ["-Xmx512M"])
