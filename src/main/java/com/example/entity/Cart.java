package com.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //eine Liste von Items
    private List<Item> itemList;

    //Konstruktor
    public Cart() {
        itemList = new ArrayList<>();
    }

    //zum Warenkorb hinzufügen
    public void addProduct(Product p) {
        itemList.add(new Item(p, 1));
    }

    //vom Warenkorb entfernen
    public void removeItemById(String id) {
        itemList.remove(isProductInCart(id));
    }

    //Warenkorb leeren
    public void removeAllItems() {
        itemList = new ArrayList<>();
    }

    //gibt die Position eines Produktes im Warenkorb zurück oder -1 wenn es nicht vorhanden ist
    private int isProductInCart(String productId) {
        for(Item item : itemList) {
            if(item.getProduct().getId().equals(productId)) {
                return itemList.indexOf(item);
            }
        }
        return -1;
    }

    //gibt die Item Liste zurück
    public List<Item> getItemList() {
        return itemList;
    }

}
