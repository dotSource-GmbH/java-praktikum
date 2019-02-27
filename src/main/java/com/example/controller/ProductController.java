package com.example.controller;

import com.example.entity.Product;
import com.example.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "products")
public class ProductController {

    //Weiterleitung an Produktübersicht
    @GetMapping("")
    public String index() {
        return "redirect:/products/all";
    }

    //Produktübersicht
    @GetMapping("all")
    public ModelAndView showAllProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", new ProductModel().findAll());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    //Produktdetailseite
    @GetMapping("id/{id}")
    public ModelAndView showProduct(@PathVariable("id") String id) {
        Product product = new ProductModel().find(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("product", product);
            modelAndView.setViewName("productDetail");
            return modelAndView;
        }
        return new ModelAndView("redirect:/products/all");
    }

}
