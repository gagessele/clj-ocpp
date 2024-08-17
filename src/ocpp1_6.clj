(ns io.clj-ocpp.ocpp1_6
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(s/def :authorization/status #{:accepted :blocked :expired :invalid :concurrent-tx})

(s/def :identifier/id-token (s/and string? (complement str/blank?) #(>= 20 (count %))))

(s/def :identifier/parent-id-tag :identifier/id-token)
(s/def :identifier/expiry-date inst?)
(s/def :identifier/id-tag-info
  (s/keys :req-un [:authorization/status]
          :opt-un [:identifier/expiry-date
                   :identifier/parent-id-tag]))
