package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    //gibt das zur ID gehörige Produkt zurück
    Product findProductById(String id);

    //gibt alle Produkte zurück
    List<Product> findAll();

}
