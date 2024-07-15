package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.model.Meal;
import com.example.restaurant.service.MealService;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    @Autowired
    private MealService mealService;
    
    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/getbyid/{id}")
    public Meal getMeal(@PathVariable Long id) {
        return mealService.getMeal(id);
    }
    
    @PostMapping("/category/{categoryId}")
    public Meal createMeal(@PathVariable Long categoryId, @RequestBody Meal meal) {
        return mealService.createMeal(categoryId, meal);
    }
    
    @PostMapping("/bulk/category/{categoryId}")
    public List<Meal> createMeals(@PathVariable Long categoryId, @RequestBody List<Meal> meals) {
        return mealService.createMeals(categoryId, meals);
    }
    
    @PutMapping("/updatebyid/{id}")
    public Meal updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
        return mealService.updateMeal(id, meal);
    }
    
    @DeleteMapping("/deletebyid/{id}")
    public void deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
    }
    
    @GetMapping("/category/{categoryId}/item/{itemId}")
    public Meal getMealByCategoryAndId(@PathVariable Long categoryId, @PathVariable Long itemId) {
        return mealService.getMealByCategoryAndId(categoryId, itemId);
    }
    
    @GetMapping("/category/{categoryId}")
    public List<Meal> getMealsByCategory(@PathVariable Long categoryId) {
        return mealService.getMealsByCategory(categoryId);
    }
}
