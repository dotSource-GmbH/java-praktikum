package com.example.controller;

import javax.servlet.http.HttpSession;

import com.example.entity.Cart;
import com.example.model.CartModel;
import com.example.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    //Warenkorbseite
    @GetMapping("")
    public ModelAndView index(HttpSession session) {
        return createCartView(CartModel.getCartForSessionId(session.getId()));
    }

    //zum Warenkorb hinzufügen
    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public ModelAndView addProductToCart(@RequestParam("id") String productId, HttpSession session) {
        Cart cart = CartModel.getCartForSessionId(session.getId());
        cart.addProduct(new ProductModel().find(productId));
        return createCartView(cart);
    }

    //vom Warenkorb entfernen
    @RequestMapping(value = "remove", method = {RequestMethod.POST})
    public ModelAndView removeProductFromCart(@RequestParam("id") String id, HttpSession session) {
        Cart cart = CartModel.getCartForSessionId(session.getId());
        cart.removeItemById(id);
        return createCartView(cart);
    }

    //Warenkorb leeren
    @RequestMapping(value = "removeAll", method = {RequestMethod.POST})
    public ModelAndView removeAllProductsFromCart(HttpSession session) {
        Cart cart = CartModel.getCartForSessionId(session.getId());
        cart.removeAllItems();
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
