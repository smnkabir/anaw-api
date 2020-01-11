package com.vectorit.anaw.service;

import com.vectorit.anaw.model.Product;
import com.vectorit.anaw.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//        return productRepository.findAllByProduct_name(name);
        return null;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
