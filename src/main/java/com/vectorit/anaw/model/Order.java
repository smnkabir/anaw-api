package com.vectorit.anaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    Long id;
    User user;
    Address address;
    List<SelectedProduct> productList;
    double cost;
    int status=0;
}
