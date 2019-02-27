package com.example.helper;

import com.example.entity.Product;

import java.util.List;

public class ProductList {

    //Produkt Liste
    private List<Product> productList;

    //Konstruktor
    public ProductList() {}

    //Konstruktor
    public ProductList(List<Product> productList) {
        this.productList = productList;
    }

    //gibt die Produkt Liste zurück
    public List<Product> getProductList() {
        return productList;
    }
}
