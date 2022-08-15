package com.example.springrestfulpractice.model;

import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findById(int id);
    Long deleteById(int id);

}
