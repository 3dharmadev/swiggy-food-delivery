package com.dharmadev.swiggy.controller;

import com.dharmadev.swiggy.exception.RestaurantException;
import com.dharmadev.swiggy.model.Restaurant;
import com.dharmadev.swiggy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        try {
            Restaurant addedRestaurant = restaurantService.addRestaurant(restaurant);
            return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
        } catch (RestaurantException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable int restaurantId) {
        try {
            Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } catch (RestaurantException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurant updatedRestaurant) {
        try {
            Restaurant restaurant = restaurantService.updateRestaurantDetails(restaurantId, updatedRestaurant);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } catch (RestaurantException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable int restaurantId) {
        try {
            Restaurant deletedRestaurant = restaurantService.deleteRestaurant(restaurantId);
            return new ResponseEntity<>(deletedRestaurant, HttpStatus.OK);
        } catch (RestaurantException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

