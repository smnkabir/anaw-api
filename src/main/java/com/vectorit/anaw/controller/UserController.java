package com.vectorit.anaw.controller;

import com.vectorit.anaw.model.Product;
import com.vectorit.anaw.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    List<User> userList = new ArrayList<>();
    @GetMapping(value = "")
    ResponseEntity<List<User>> getProducts(){
        return ResponseEntity.ok(userList);
    }
}
