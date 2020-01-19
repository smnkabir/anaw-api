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
    Address address;
    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "products")
    List<SelectedProduct> productList;
    double cost;
    int status = 0;

    public DBOrder(String userName, Address address, List<SelectedProduct> productList, double cost) {
        this.userName = userName;
        this.address = address;
        this.productList = productList;
        this.cost = cost;
    }
    public DBOrder(String userName, Address address, List<SelectedProduct> productList, double cost,int status) {
        this.userName = userName;
        this.address = address;
        this.productList = productList;
        this.cost = cost;
        this.status = status;
    }
}
