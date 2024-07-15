package com.example.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.model.Category;
import com.example.restaurant.model.Meal;
import com.example.restaurant.repository.CategoryRepository;
import com.example.restaurant.repository.MealRepository;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
    
    public Meal getMeal(Long id) {
        return mealRepository.findById(id).orElse(null);
    }
    
    public Meal createMeal(Long categoryId, Meal meal) {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        meal.setCategory(category);
        return mealRepository.save(meal);
    }
    
    public List<Meal> createMeals(Long categoryId, List<Meal> meals) {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        meals.forEach(meal -> meal.setCategory(category));
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
        return mealRepository.findByCategory_IdAndId(categoryId, itemId)
            .orElseThrow(() -> new RuntimeException("Meal not found"));
    }
    
    public List<Meal> getMealsByCategory(Long categoryId) {
        return mealRepository.findByCategoryId(categoryId);
    }
}
