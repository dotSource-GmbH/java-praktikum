package com.example.model;

import com.example.entity.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartModel {

    //Zuordnung von Session ID's zu Warenkörben
    private static Map<String, Cart> carts = new HashMap<>();

    //Konstruktor
    private CartModel() {}

    //liefert den zur Session ID gehörigen Warenkorb zurück oder erstellt einen neuen wenn er nicht vorhanden ist
    public static Cart getCartForSessionId(String sessionId) {
        if(carts.containsKey(sessionId)) {
            return carts.get(sessionId);
        }
        Cart cart = new Cart();
        carts.put(sessionId, cart);
        return cart;
    }

}
