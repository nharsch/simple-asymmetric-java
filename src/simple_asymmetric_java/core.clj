(ns simple-asymmetric-java.core
  (:require [caesium.crypto.secretbox :as sb]
  [caesium.crypto.sign :as sign]
    ))


(def mykey (sb/new-key!))
(def plaintext "Hello caesium!")
(def nonce (sb/int->nonce 0))
(def ciphertext (sb/encrypt mykey nonce (.getBytes plaintext)))
(def roundtrip (String. (sb/decrypt mykey nonce ciphertext)))
(assert (= plaintext roundtrip))

;; function in crypto.ts
; TODO: how can I export this function for external use?
(defn generateKeys
  (sign/keypair!))

;TODO pick up here
(defn hashPassword
  [password salt]
  )
