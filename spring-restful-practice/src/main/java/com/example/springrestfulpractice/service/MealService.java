package com.example.springrestfulpractice.service;


import com.example.springrestfulpractice.model.entity.Meal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MealService {
    List<Meal> mealList=new ArrayList<>();
    public MealService(){
        super();
        Meal meal = new Meal(1,"hamburger", 120,"david is good" );
        this.mealList.add(meal);
    }

    public Meal getMealByName(String name) {
        for (int i = 0; i < this.mealList.size(); i++) {
            if (this.mealList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                return this.mealList.get(i);
            }
        }
        return null;


    }
}
