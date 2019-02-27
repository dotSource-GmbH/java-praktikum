package com.example.controller;

import com.example.entity.Product;
import com.example.helper.ProductList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "products")
public class ProductController {

    //URL zur Produkt REST Schnittstelle
    private String REST_PRODUCT_URL = "http://localhost:8080/restproducts";

    //Weiterleitung an Produktübersicht
    @GetMapping("")
    public String index() {
        return "redirect:/products/all";
    }

    //Produktübersicht
    @GetMapping("all")
    public ModelAndView showAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> productList = restTemplate.getForObject(REST_PRODUCT_URL, ProductList.class).getProductList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    //Produktdetailseite
    @GetMapping("id/{id}")
    public ModelAndView showProduct(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(REST_PRODUCT_URL + "/id/" + id, Product.class);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("product", product);
            modelAndView.setViewName("productDetail");
            return modelAndView;
        }
        return new ModelAndView("redirect:/products/all");
    }

}
