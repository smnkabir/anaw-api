package com.vectorit.anaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String email;
    @Id
    private String userName;
    private String password;
    private Address address;
    private String number;
    @Enumerated(EnumType.STRING)
    private Person_type category;

}
