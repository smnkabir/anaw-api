package com.vectorit.anaw.service;

import com.vectorit.anaw.model.DBOrder;
import com.vectorit.anaw.model.Order;
import com.vectorit.anaw.model.User;
import com.vectorit.anaw.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    OrderRepository orderRepository;
    UserService userService;

    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public List<Order> findALlOrder() {
        List<DBOrder> dborderList = new ArrayList<>();
        orderRepository.findAll().forEach(dborderList :: add);
        List<Order> orderList = new ArrayList<>();
        dborderList.stream().forEach(dbOrder -> {
            User user = userService.getAll(dbOrder.getUserName());
            orderList.add(new Order(user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost()));
        });

        return  orderList;
    }
    public Order findALlOrder(String userName) {
        List<DBOrder> dborderList = new ArrayList<>();
        orderRepository.findAll().forEach(dborderList :: add);
        List<Order> orderList = new ArrayList<>();
        DBOrder dbOrder = dborderList.stream().filter(o -> o.getUserName().equals(userName))
                .findAny()
                .orElse(null);
        Order order = null;
        if(dbOrder != null){
            User user = userService.getAll(dbOrder.getUserName());
            order = new Order(user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost());
        }

        return  order;
    }

    public Order saveOrder(Order order) {
        DBOrder dbOrder = new DBOrder(order.getUser().getUserName(),order.getAddress(),order.getProductList(),order.getCost());
        orderRepository.save(dbOrder);
        return order;
    }

    public void delete(String userName) {
        List<DBOrder> dborderList = new ArrayList<>();
        orderRepository.findAll().forEach(dborderList :: add);

        List<DBOrder> dbOrderList = dborderList.stream().filter(o -> o.getUserName().equals(userName))
                                    .collect(Collectors.toList());
        DBOrder dbOrder = dbOrderList.get(0);
        if (dbOrder != null)
            orderRepository.delete(dbOrder);
    }
}
