package com.vectorit.anaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DBOrder {
    @Id
    @GeneratedValue
    Long id;

    String userName;

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "products")
    List<SelectedProduct> productList;
    double cost;

    public DBOrder(String userName, List<SelectedProduct> productList, double cost) {
        this.userName = userName;
        this.productList = productList;
        this.cost = cost;
    }
}
