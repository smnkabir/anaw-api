package com.vectorit.anaw.controller;

import com.vectorit.anaw.model.User;
import com.vectorit.anaw.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "{username}")
    ResponseEntity<User> getUsers(@PathVariable String username){
        User user = userService.getAll(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "")
    public ResponseEntity<User> saveProduct(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "{username}")
    public ResponseEntity<User> deleteUser(@PathVariable String username){
        User user = userService.deleteUser(username);
        return ResponseEntity.ok(user);
    }
}
