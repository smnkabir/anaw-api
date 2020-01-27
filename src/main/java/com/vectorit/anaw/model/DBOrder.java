package com.vectorit.anaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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
    Long date;

    public DBOrder(String userName, Address address, List<SelectedProduct> productList, double cost, Long date) {
        this.userName = userName;
        this.address = address;
        this.productList = productList;
        this.cost = cost;
        this.date = date;
    }
    public DBOrder(String userName, Address address, List<SelectedProduct> productList, double cost,int status, Long date) {
        this.userName = userName;
        this.address = address;
        this.productList = productList;
        this.cost = cost;
        this.status = status;
        this.date = date;
    }
}
