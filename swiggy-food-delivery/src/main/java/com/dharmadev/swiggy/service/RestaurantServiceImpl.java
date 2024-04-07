package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.RestaurantException;
import com.dharmadev.swiggy.model.Restaurant;
import com.dharmadev.swiggy.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
        if (restaurant == null) {
            throw new RestaurantException("Restaurant details cannot be null");
        }
        if (restaurantRepository.existsById(restaurant.getRestaurantId())) {
            throw new RestaurantException("Restaurant with id " + restaurant.getRestaurantId() + " already exists");
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) throws RestaurantException {
        Optional<Restaurant> optional = restaurantRepository.findById(restaurantId);
        if (optional.isEmpty()) {
            throw new RestaurantException("Restaurant with id " + restaurantId + " not found");
        } else {
            return optional.get();
        }
    }

    @Override
    public Restaurant updateRestaurantDetails(int restaurantId, Restaurant updatedRestaurant) throws RestaurantException {
        Optional<Restaurant> optional = restaurantRepository.findById(restaurantId);
        if (optional.isEmpty()) {
            throw new RestaurantException("Restaurant with id " + restaurantId + " not found");
        }
        Restaurant restaurant = optional.get();
        restaurant.setRestaurantName(updatedRestaurant.getRestaurantName());
        restaurant.setAddress(updatedRestaurant.getAddress());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant deleteRestaurant(int restaurantId) throws RestaurantException {
        Optional<Restaurant> optional = restaurantRepository.findById(restaurantId);
        if (optional.isEmpty()) {
            throw new RestaurantException("Restaurant with id " + restaurantId + " not found");
        }
        Restaurant deletedRestaurant = optional.get();
        restaurantRepository.deleteById(restaurantId);
        return deletedRestaurant;
    }
}
