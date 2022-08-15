package com.example.springrestfulpractice.controller.dto.request;

import com.example.springrestfulpractice.model.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatOrderRequest {
    private int seq;
    private int totalPrice;
    private String waiter;
    private List<Meal> mealList;
}
