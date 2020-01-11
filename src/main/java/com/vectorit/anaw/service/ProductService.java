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
        return productList.stream().filter(product -> product.getProduct_name().equals(name))
                .findAny()
                .orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
