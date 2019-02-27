package com.example.entity;

public class Product {

    //ID
    private String id;
    //Name
    private String name;
    //Beschreibung
    private String description;
    //Foto (Bsp.: bild.jpg)
    private String photo;
    //Preis
    private int price;

    //Konstruktor
    public Product() {}

    //Konstruktor
    public Product(String id, String name, String description, String photo, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
    }

    //gibt die ID zurück
    public String getId() {
        return id;
    }

    //gibt den Namen zurück
    public String getName() {
        return name;
    }

    //gibt die Beschreibung zurück
    public String getDescription() {
        return description;
    }

    //gibt das Foto zurück
    public String getPhoto() {
        return photo;
    }

    //gibt den Preis zurück
    public int getPrice() {
        return price;
    }
}
