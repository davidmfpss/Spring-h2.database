package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.controller.dto.request.CreatOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.model.OrderRepository;
import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private List<Order> orderList ;

    /*public OrderService() {
        List<Meal> mealList1 = new ArrayList<>();
        mealList1.add(new Meal("hamburger", 2500, "good"));
        mealList1.add(new Meal("hamburger", 2300, "good"));
        List<Meal> mealList2 = new ArrayList<>();
        mealList2.add(new Meal("hamburger", 1000, "good"));
        this.orderList.add(new Order(1, 1000, "david", mealList1));
        this.orderList.add(new Order(2, 2000, "david", mealList2));
    }*/

    public List<Order> getAllOrders() {
        List<Order> response=orderRepository.findAll();
        return response;
    }

    public Order getOrder(int seq) {
        Order response=this.orderRepository.findById(seq);
        return response;
    }

    public String creatOrder(CreatOrderRequest request) {
        Order order=new Order();
        order.setSeq(request.getSeq());
        order.setWaiter(request.getWaiter());
        order.setMealList(request.getMealList());
        orderRepository.save(order);
        return "OK";
    }

    public String updateOrder(int seq, UpdateOrderRequest request) {
        Order order = orderRepository.findById(seq);
        if (null == order) {
            return "FAIL";
        }
        order.setWaiter(request.getWaiter());
        order.setMealList(request.getMealList());
        orderRepository.save(order);
        return "OK";
    }

    public String deleteOrder(int seq) {
        Order order = orderRepository.findById(seq);
        if (null == order) {
            return "FAIL";
        }
        orderRepository.deleteById(seq);
        return "OK";
    }
}

