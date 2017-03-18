(ns simple-asymmetric-java.core
  (:require 
    [caesium.crypto.secretbox :as sb]
    [caesium.crypto.sign :as sign]
    ;; [caesium.crypto.sodium:as s]
    ))


;; function in crypto.ts
; TODO: how can I export this function for external use?
(def generateKeys
  sign/keypair!)
; make sure keys are different
(assert 
  (false? (= 
            (:public (generateKeys)) 
            (:public (generateKeys)))))


(defn from_base54
  [string]
  ;TODO: how to coerce 64 string to array of 8 bit int 
  (byte-array string))

;TODO pick up here
(defn hashPassword
  "accepts base64 string or bytearray" 
  [password salt]
  (let [salt (if (instance? String salt)
            (from_base64 salt)
            salt)]
    (s/crypto_pwhash
      s/crypto_box_SEEDBYTES
      password
      salt
      s/crypto_pwhash_OPSLIMIT_INTERACTIVE
      s/crypto_pwhash_MEMLIMIT_INTERACTIVE
      s/crypto_pwhash_ALG_DEFAULT)))

(defn maskeSalt)

(defn encrypt)

(defn decrypt)

(defn exportPrivateKey)

(defn importKeyPair)

(defn makeNonc)

(defn rsaEncrypt)

(defn rsaDecrypt)

(s/from_base64 "test")

(instance? (Class/forName "[B") (byte-array [3 5 8]))
(instance? String "yup")
