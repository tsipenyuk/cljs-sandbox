(ns app.core)

(defn mount []
  (let [app (.getElementById js/document "app")]
    (set! (.-innerText app) "Hello, ClojureScript!")))

(defn init []
  (mount))
