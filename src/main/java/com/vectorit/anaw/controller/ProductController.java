package com.vectorit.anaw.controller;



import com.vectorit.anaw.model.Address;
import com.vectorit.anaw.model.Category;
import com.vectorit.anaw.model.Product;
import com.vectorit.anaw.model.Shop;
import com.vectorit.anaw.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.findALlProduct());
    }

    @GetMapping(value = "/{name}")
    ResponseEntity<Product> getProduct(@PathVariable String name){
        return ResponseEntity.ok(productService.findALlProduct(name));
    }

    @PostMapping(value = "")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    /*void createSampleData(){
        productList.add(new Product("singara",5,new Shop("alimama",new Address("13","05","5b","C","Bashundhora")), Category.Food));
        productList.add(new Product("samucha",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Food));
        productList.add(new Product("singara",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Food));
        productList.add(new Product("samucha",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Food));

        productList.add(new Product("singara",5,new Shop("alimama",new Address()), Category.Food));
        productList.add(new Product("samucha",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Food));
        productList.add(new Product("singara",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Food));
        productList.add(new Product("samucha",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Food));

        productList.add(new Product("Hollywood",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));
        productList.add(new Product("Banson",10,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));
        productList.add(new Product("Malboro",10,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));
        productList.add(new Product("Akij",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));

        productList.add(new Product("Hollywood",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));
        productList.add(new Product("Banson",10,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));
        productList.add(new Product("Malboro",10,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));
        productList.add(new Product("Akij",5,new Shop("alimama",new Address("13","05","5b","","Nikunja")), Category.Cigarette));


    }*/
}
