package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.RestaurantException;
import com.dharmadev.swiggy.model.Restaurant;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException;
    Restaurant getRestaurant(int restaurantId) throws RestaurantException;
    Restaurant updateRestaurantDetails(int restaurantId, Restaurant updatedRestaurant) throws RestaurantException;
    Restaurant deleteRestaurant(int restaurantId) throws RestaurantException;
}
