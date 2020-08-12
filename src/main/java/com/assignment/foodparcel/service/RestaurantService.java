package com.assignment.foodparcel.service;

import com.assignment.foodparcel.model.Restaurant;
import com.assignment.foodparcel.model.User;
import com.assignment.foodparcel.payload.RestaurantCO;
import com.assignment.foodparcel.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private static final Logger logger = LoggerFactory.getLogger(FoodService.class);
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserService userService;

    private Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    private void delete(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }

    public Restaurant createRestaurant(RestaurantCO restaurantCO) {
        Long userId = Long.parseLong(restaurantCO.getUserId());
        User user = userService.getUserByUserId(userId);
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantCO.getName());
        restaurant.setEmailId(restaurantCO.getEmailId());
        restaurant.setPhoneNumber(restaurantCO.getPhoneNumber());
        restaurant.setUser(user);
        return save(restaurant);
    }

    public boolean restaurantExistsByNameForUser(String restaurantName, Long userId) {
        User user = userService.getUserByUserId(userId);
        return restaurantRepository.existsByNameAndUser(restaurantName, user);
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return restaurant.get();
    }

    public List<Restaurant> getAllRestaurantByName(String restaurantName) {
        return restaurantRepository.getAllByName(restaurantName);
    }
}
