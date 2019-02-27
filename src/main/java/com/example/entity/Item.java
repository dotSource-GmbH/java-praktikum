package com.example.entity;

public class Item {

    //Produkt
    private Product product;
    //Stückzahl
    private int quantity;

    //Konstruktor
    public Item() {}

    //Konstruktor
    Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //gibt das Produkt zurück
    public Product getProduct() {
        return product;
    }

    //gibt die Stückzahl zurück
    public int getQuantity() {
        return quantity;
    }

    //ändert die Stückzahl
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
