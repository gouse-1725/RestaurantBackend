package com.example.restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurant.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
	List<Meal> findByCategoryId(Long categoryId);
    Optional<Meal> findByCategory_IdAndId(Long categoryId, Long itemId);
}
