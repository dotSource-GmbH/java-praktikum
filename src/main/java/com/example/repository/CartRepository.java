package com.example.repository;

import com.example.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart, String> {

    //gibt den zur Session ID gehörigen Warenkorb zurück
    Cart findCartBySessionId(String sessionId);

    //gibt alle Warenkörbe zurück
    List<Cart> findAll();

}
