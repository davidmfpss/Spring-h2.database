package com.example.springrestfulpractice.controller;


import com.example.springrestfulpractice.controller.dto.request.CreatOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.controller.dto.response.StatusResponse;
import com.example.springrestfulpractice.model.entity.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return orderList;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = this.orderService.getOrder(id);
        return order;
    }

    @PostMapping()
    public StatusResponse creatOrder(@RequestBody CreatOrderRequest request) {
        String response = this.orderService.creatOrder(request);
        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateOrder(@PathVariable int id, @RequestBody UpdateOrderRequest request) {
        String response  = this.orderService.updateOrder(id, request);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteOrder(@PathVariable int id) {
        String response = this.orderService.deleteOrder(id);
        return new StatusResponse(response);
    }


}

