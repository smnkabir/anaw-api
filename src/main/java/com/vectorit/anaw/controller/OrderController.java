package com.vectorit.anaw.controller;

import com.vectorit.anaw.model.Order;
import com.vectorit.anaw.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "")
    ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok(orderService.findALlOrder());
    }

    @GetMapping(value = "/{userName}")
    ResponseEntity<Order> getProduct(@PathVariable String userName){
        return ResponseEntity.ok(orderService.findALlOrder(userName));
    }

    @PostMapping(value = "")
    public ResponseEntity<Order> saveProduct(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value="{userName}")
    public  ResponseEntity deleteProduct(@PathVariable String userName){
        orderService.delete(userName);
        return ResponseEntity.ok().build();
    }
}
