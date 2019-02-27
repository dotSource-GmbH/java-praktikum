package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //URL zur Produkt REST Schnittstelle
    private String REST_PRODUCT_URL = "http://localhost:8080/restproducts/";

    //aktuelle Session ID des Nutzers
    @Id
    private String sessionId;

    //Item Liste
    private List<Item> itemList;

    //Konstruktor
    public Cart() {
        itemList = new ArrayList<>();
    }

    //Konstruktor
    public Cart(String sessionId) {
        this.sessionId = sessionId;
        itemList = new ArrayList<>();
    }

    //zum Warenkorb hinzufügen
    public void addProduct(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(REST_PRODUCT_URL + "id/" + productId, Product.class);
        int index = isProductInCart(productId);
        if (index == -1) {
            itemList.add(new Item(product, 1));
        } else {
            itemList.get(index).setQuantity(itemList.get(index).getQuantity() + 1);
        }
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
