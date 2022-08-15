package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/meal")
public class MealController {
    @Autowired
    MealService mealservice;

    @GetMapping()
    public String getMealByName(@RequestParam String name, Model model) {
        Meal meal = this.mealservice.getMealByName(name);
        model.addAttribute("meal", meal);
        return "meal";
    }

}
