package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @PostMapping
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.createMeal(meal);
    }
    
    @PostMapping("/bulk")
    public List<Meal> createMeals(@RequestBody List<Meal> meals) {
        return mealService.createMeals(meals);
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
}
