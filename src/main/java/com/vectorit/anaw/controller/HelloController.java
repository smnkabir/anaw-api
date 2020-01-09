package com.vectorit.anaw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/hello")
public class HelloController {
    @GetMapping(value = "")
    public String sayHello(){
        return "hello";
    }
}
