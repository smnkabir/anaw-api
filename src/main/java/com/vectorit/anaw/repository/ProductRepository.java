package com.vectorit.anaw.repository;

import com.vectorit.anaw.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
//    Product findAllByProduct_name(String name);
}
