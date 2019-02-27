package com.example.restController;

import com.example.entity.Cart;
import com.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "restcarts")
public class CartRestController {

    //Warenkorb Repository
    @Autowired
    private CartRepository repository;

    //gibt alle Warenkörbe zurück
    @RequestMapping("")
    public List<Cart> index() {
        return repository.findAll();
    }

    //gibt den zur Session ID gehörigen Warenkorb zurück oder erstellt einen in der DB wenn er noch nicht vorhanden ist
    @RequestMapping("current/{sessionId}")
    public Cart getCurrentCart(@PathVariable String sessionId) {
        Cart cart = repository.findCartBySessionId(sessionId);
        if(cart == null) {
            cart = new Cart(sessionId);
        }
        repository.save(cart);
        return cart;
    }

    //fügt ein Produkt zum Warenkorb mit der Nutzer Session ID hinzu
    @RequestMapping("/add/{sessionId}/product/{productId}")
    public Cart addProductToCart(@PathVariable String productId, @PathVariable String sessionId) {
        Cart cart = repository.findCartBySessionId(sessionId);
        if(cart == null) {
            cart = new Cart(sessionId);
        }
        cart.addProduct(productId);
        repository.save(cart);
        return cart;
    }

    //entfernt ein Produkt vom Warenkorb mit der Nutzer Session ID
    @RequestMapping("remove/{sessionId}/product/{productId}")
    public Cart removeProductFromCart(@PathVariable String productId, @PathVariable String sessionId) {
        Cart cart = repository.findCartBySessionId(sessionId);
        cart.removeItemById(productId);
        repository.save(cart);
        return cart;
    }

    //leert den zur Nutzer Session ID gehörigen Warenkorb
    @RequestMapping("clear/{sessionId}")
    public Cart removeAllProductsFromCart(@PathVariable String sessionId) {
        Cart cart = repository.findCartBySessionId(sessionId);
        cart.removeAllItems();
        repository.save(cart);
        return cart;
    }


}
