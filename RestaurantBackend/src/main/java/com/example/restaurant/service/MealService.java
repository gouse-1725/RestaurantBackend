package com.example.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.model.Meal;
import com.example.restaurant.repository.MealRepository;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;
    
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
    
    public Meal getMeal(Long id) {
        return mealRepository.findById(id).orElse(null);
    }
    
    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }
    
    public List<Meal> createMeals(List<Meal> meals) {
        return mealRepository.saveAll(meals);
    }
    
    public Meal updateMeal(Long id, Meal meal) {
        if (mealRepository.existsById(id)) {
            meal.setId(id);
            return mealRepository.save(meal);
        }
        return null;
    }
    
    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
    
    public Meal getMealByCategoryAndId(Long categoryId, Long itemId) {
        return mealRepository.findByCategory_IdAndId(categoryId, itemId).orElseThrow();
    }
}
