package com.vectorit.anaw.service;

import com.vectorit.anaw.model.Product;
import com.vectorit.anaw.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findALlProduct(){
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(product -> productList.add(product));
        return productList;
    }

    public Product findALlProduct(String name){
        List<Product> productList = new ArrayList<>();
        productRepository.findAll()
                .forEach( productList :: add);
        return productList.stream().filter(product -> product.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product delete(String name) {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll()
                .forEach( productList :: add);

        Product product = productList.stream().filter(p -> p.getName().equals(name))
                .findAny()
                .orElse(null);
        if(product != null)
            productRepository.delete(product);
        return product;
    }
}
