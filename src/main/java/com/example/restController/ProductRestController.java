package com.example.restController;

import com.example.entity.Product;
import com.example.helper.ProductList;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "restproducts")
public class ProductRestController {

    //Produkt Repository
    @Autowired
    private ProductRepository repository;

    //gibt alle Produkte zurück
    @RequestMapping("")
    public ProductList index() {
        return new ProductList(repository.findAll());
    }

    //gibt ein Produkt zurück
    @RequestMapping("id/{id}")
    public Product showProduct(@PathVariable String id) {
        return repository.findProductById(id);
    }

    //fügt ein Produkt zur DB hinzu
    @RequestMapping("add")
    public Product addProduct(@RequestParam String id, @RequestParam String name, @RequestParam String description, @RequestParam String photo, @RequestParam int price) {
        Product product = new Product(id, name, description, photo, price);
        repository.save(product);
        return product;
    }

    //entfernt ein Produkt aus der DB
    @RequestMapping("remove/{id}")
    public void removeProductById(@PathVariable String id) {
        repository.deleteById(id);
    }
}
