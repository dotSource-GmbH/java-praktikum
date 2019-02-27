package com.example.model;

import com.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    //Produktliste
    private List<Product> productList;

    //Konstruktor
    public ProductModel() {
        productList = new ArrayList<>();
        productList.add(new Product("1", "Ananas", "eine ganz normale Ananas", "ananas.jpg", 20));
        productList.add(new Product("2", "Birne", "eine ganz normale Birne", "birneeeeeeeeeeeee.jpg", 21));
        productList.add(new Product("3", "Apfel", "ein ganz normaler Apfel", "apfel.jpg", 22));
        productList.add(new Product("4", "Wassermelone", "eine ganz normale Wassermelone", "wassermelone.jpg", 23));
        productList.add(new Product("5", "Kirsche", "eine ganz normale Kirsche", "kirssssche.jpg", 24));
    }

    //gibt die Produktliste zurück
    public List<Product> findAll() {
        return productList;
    }

    //gibt das Produkt zurück oder null wenn es nicht existiert
    public Product find(String id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

}
