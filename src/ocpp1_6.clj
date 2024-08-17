(ns io.clj-ocpp.ocpp1_6
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(s/def :identifier/id-token (s/and string? (complement str/blank?) #(>= 20 (count %))))

(s/valid? :identifier/id-token nil)
(s/valid? :identifier/id-token "")
(s/valid? :identifier/id-token "abcd")
(s/valid? :identifier/id-token "aaaaaaaaaaaaaaaaaaaaa")
