package com.assignment.foodparcel.service;

import com.assignment.foodparcel.model.FoodItem;
import com.assignment.foodparcel.model.Restaurant;
import com.assignment.foodparcel.payload.FoodItemCO;
import com.assignment.foodparcel.repository.FoodItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodService.class);

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestaurantService restaurantService;

    private FoodItem save(FoodItem foodItem) {
        logger.info("****** saving food item *******");
        return foodItemRepository.save(foodItem);
    }

    private void delete(FoodItem foodItem) {
        foodItemRepository.delete(foodItem);
    }

    public FoodItem createFoodItem(FoodItemCO foodItemCO) {
        Long restaurantId = Long.parseLong(foodItemCO.getRestaurantId());
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        FoodItem foodItem = new FoodItem();
        foodItem.setName(foodItemCO.getName());
        foodItem.setDescription(foodItemCO.getDescription());
        foodItem.setPrice(foodItemCO.getPrice());
        foodItem.setRestaurant(restaurant);
        return save(foodItem);
    }

}
