package com.example.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurant.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findByCategory_IdAndId(Long categoryId, Long itemId);
}
