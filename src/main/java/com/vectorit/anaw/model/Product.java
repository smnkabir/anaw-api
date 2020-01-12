package com.vectorit.anaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product {
    @Id
    @GeneratedValue
    long productId;
    String name;
    double price;
    Shop shop;
    @Enumerated(EnumType.STRING)
    Category category;
}
