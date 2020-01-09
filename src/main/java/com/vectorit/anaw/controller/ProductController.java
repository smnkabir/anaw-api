package com.vectorit.anaw.controller;



import com.vectorit.anaw.model.Address;
import com.vectorit.anaw.model.Category;
import com.vectorit.anaw.model.Product;
import com.vectorit.anaw.model.Shop;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    List<Product> productList;

    public ProductController() {
        this.productList = new ArrayList<>();
        createSampleData();
    }

    @GetMapping(value = "")
    ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productList);
    }

    @GetMapping(value = "/{name}")
    ResponseEntity<Product> getProduct(@PathVariable String name){
        List<Product> products = productList.stream().filter(p -> p.getProduct_name().equals(name))
                .collect(Collectors.toList());
        return ResponseEntity.ok(products.get(0));
    }

    void createSampleData(){
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


    }
}
