package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    
    @GetMapping("/getbyid/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }
    
    
    
    
    @PostMapping
    public List<Restaurant> createRestaurants(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.createRestaurants(restaurants);
    }
    
    
    @PutMapping("/updatebyid/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }
    
    @DeleteMapping("/deletebyid/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
