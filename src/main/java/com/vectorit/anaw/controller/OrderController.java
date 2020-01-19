package com.vectorit.anaw.controller;

import com.vectorit.anaw.model.Order;
import com.vectorit.anaw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "")
    ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok(orderService.findAllOrder());
    }

    @GetMapping(value = "/{userName}")
    ResponseEntity<List<Order>> getProduct(@PathVariable String userName){
        return ResponseEntity.ok(orderService.findAllOrder(userName));
    }

    @GetMapping(value = "/rider")
    ResponseEntity<List<Order>> getOrdersForRider(){
        return ResponseEntity.ok(orderService.findAllOrderForRider());
    }
    @GetMapping(value = "/paid")
    ResponseEntity<List<Order>> getOrderPaid(){
        return ResponseEntity.ok(orderService.findAllPaidOrder());
    }

    @GetMapping(value = "/remain")
    ResponseEntity<List<Order>> getOrderRemain(){
        return ResponseEntity.ok(orderService.findAllRemainOrder());
    }

    @PostMapping(value = "")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok(order);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        orderService.updaateOrder(order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value="{userName}")
    public  ResponseEntity deleteOrder(@PathVariable String userName){
        orderService.delete(userName);
        return ResponseEntity.ok().build();
    }
}
