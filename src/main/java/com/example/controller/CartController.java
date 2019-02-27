package com.example.controller;

import com.example.entity.Cart;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    //Produkt Repository
    @Autowired
    ProductRepository productRepository;

    //URL zur Warenkorb REST Schnittstelle
    private String REST_CART_URL = "http://localhost:8080/restcarts/";
    private RestTemplate restTemplate = new RestTemplate();

    //Warenkorbseite
    @GetMapping("")
    public ModelAndView index(HttpSession session) {
        Cart cart = restTemplate.getForObject(REST_CART_URL + "current/" + session.getId(), Cart.class);
        return createCartView(cart);
    }

    //zum Warenkorb hinzufügen
    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public ModelAndView addProductToCart(@RequestParam("id") String productId, HttpSession session) {
        Cart cart = restTemplate.getForObject(REST_CART_URL + "add/" + session.getId() + "/product/" + productId, Cart.class);
        return createCartView(cart);
    }

    //vom Warenkorb entfernen
    @RequestMapping(value = "remove", method = {RequestMethod.POST})
    public ModelAndView removeProductFromCart(@RequestParam("id") String productId, HttpSession session) {
        Cart cart = restTemplate.getForObject(REST_CART_URL + "remove/" + session.getId() + "/product/" + productId, Cart.class);
        return createCartView(cart);
    }

    //Warenkorb leeren
    @RequestMapping(value = "removeAll", method = {RequestMethod.POST})
    public ModelAndView removeAllProductsFromCart(HttpSession session) {
        Cart cart = restTemplate.getForObject(REST_CART_URL + "clear/" + session.getId(), Cart.class);
        return createCartView(cart);
    }

    //Warenkorbseiten Ausgabe erzeugen
    private ModelAndView createCartView(Cart cart) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cart", cart);
        modelAndView.setViewName("cart");
        return modelAndView;
    }

}
