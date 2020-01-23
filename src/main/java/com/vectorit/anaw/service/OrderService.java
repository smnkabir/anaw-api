package com.vectorit.anaw.service;

import com.vectorit.anaw.model.DBOrder;
import com.vectorit.anaw.model.Order;
import com.vectorit.anaw.model.User;
import com.vectorit.anaw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserService userService;

    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public List<Order> findAllOrder() {
        List<DBOrder> dborderList = new ArrayList<>();
        orderRepository.findAll().forEach(dborderList :: add);
        List<Order> orderList = new ArrayList<>();
        dborderList.stream().forEach(dbOrder -> {
            User user = userService.getAll(dbOrder.getUserName());
            orderList.add(new Order(dbOrder.getId(),user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost(),dbOrder.getStatus()));
        });

        return  orderList;
    }

    public List<Order> findAllOrderForRider(String area) {
        List<DBOrder> dborderList = orderRepository.findByStatus(0);
        List<Order> orderList = new ArrayList<>();

        dborderList.stream().forEach(dbOrder -> {
            User user = userService.getAll(dbOrder.getUserName());
            orderList.add(new Order(dbOrder.getId(),user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost(),dbOrder.getStatus()));
        });

        List<Order> order_area = new ArrayList<>();

        orderList.stream().forEach(order -> {
            if(order.getAddress().getArea().equals(area))
                order_area.add(order);
        });

        return  order_area;
    }

    public List<Order> findAllPaidOrder() {
        List<DBOrder> dborderList = orderRepository.findByStatus(1);
        List<Order> orderList = new ArrayList<>();

        dborderList.stream().forEach(dbOrder -> {
            User user = userService.getAll(dbOrder.getUserName());
            orderList.add(new Order(dbOrder.getId(),user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost(),dbOrder.getStatus()));
        });

        return  orderList;
    }

    public List<Order> findAllRemainOrder() {
        List<DBOrder> dborderList = orderRepository.findByStatus(0);
        List<Order> orderList = new ArrayList<>();

        dborderList.stream().forEach(dbOrder -> {
            User user = userService.getAll(dbOrder.getUserName());
            orderList.add(new Order(dbOrder.getId(),user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost(),dbOrder.getStatus()));
        });

        return  orderList;
    }

    public List<Order> findAllOrder(String userName) {
        List<DBOrder> dborderList = orderRepository.findByUserName(userName);
        List<Order> orderList = new ArrayList<>();
        DBOrder dbO = new DBOrder();
        if(dborderList.size()!= 0)
            dbO = dborderList.get(0);

        User user = userService.getAll(dbO.getUserName());

        dborderList.stream().forEach(dbOrder ->{
            orderList.add(new Order(dbOrder.getId(),user,dbOrder.getAddress(),dbOrder.getProductList(),dbOrder.getCost(),dbOrder.getStatus()));
        });


        return  orderList;
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

    public void updaateOrder(Order order) {
        Optional<DBOrder> byId = orderRepository.findById(order.getId());
        if(byId.isPresent()){
            DBOrder dbOrder = byId.get();
            orderRepository.delete(dbOrder);
            dbOrder = new DBOrder(order.getUser().getUserName(),order.getAddress(),order.getProductList(),order.getCost(),1);
            orderRepository.save(dbOrder);
        }
    }
}
