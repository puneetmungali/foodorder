package com.assignment.foodparcel.utils;

import com.assignment.foodparcel.model.Restaurant;
import com.assignment.foodparcel.model.User;
import com.assignment.foodparcel.payload.FoodItemCO;
import com.assignment.foodparcel.payload.RestaurantCO;
import com.assignment.foodparcel.payload.UserCO;
import com.assignment.foodparcel.service.FoodService;
import com.assignment.foodparcel.service.RestaurantService;
import com.assignment.foodparcel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private FoodService foodService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("******** Running database loader ***********");
        createUser();
        createRestaurant();
        createFoodItems();
        logger.info("******* Database loader execution finished **********");
    }

    private void createUser() {
        if (!userService.userExistsByUsername("puneetmungali")) {
            UserCO user = new UserCO();
            user.setUsername("puneetmungali");
            user.setName("Puneet Mungali");
            user.setPhoneNumber("0987654321");
            user.setEmailId("puneetmungali93@gmail.com");
            userService.createUser(user);
        }
    }

    private void createRestaurant() {
        User user = userService.getUserByUserName("puneetmungali");
        if (!restaurantService.restaurantExistsByNameForUser("Metro Dhaba", user.getId())) {
            RestaurantCO restaurantCO = new RestaurantCO();
            restaurantCO.setName("Metro Dhaba");
            restaurantCO.setEmailId("metrodhaba@gmail.com");
            restaurantCO.setPhoneNumber("1234567890");
            restaurantCO.setUserId(user.getId().toString());
            restaurantService.createRestaurant(restaurantCO);
        }
    }

    private void createFoodItems() {
        List<Restaurant> restaurantList = restaurantService.getAllRestaurantByName("Metro Dhaba");
        if (!restaurantList.isEmpty()) {
            Restaurant restaurant = restaurantList.get(0);
            FoodItemCO foodItemCO = new FoodItemCO();
            foodItemCO.setName("Rajma");
            foodItemCO.setDescription("Delicious Rajma with curry leaves");
            foodItemCO.setPrice(60.0f);
            foodItemCO.setRestaurantId(restaurant.getId().toString());
            foodService.createFoodItem(foodItemCO);
        }
    }
}
