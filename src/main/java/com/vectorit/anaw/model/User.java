package com.vectorit.anaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private String userName;
    private String password;
    private Address address;
    private String number;
    private Person_type category;

    public User(String name, String userName, String password, Address address, String number, Person_type category) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.number = number;
        this.category = category;
    }
}
