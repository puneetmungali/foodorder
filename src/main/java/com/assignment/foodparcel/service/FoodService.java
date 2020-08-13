package com.assignment.foodparcel.service;

import com.assignment.foodparcel.model.FoodItem;
import com.assignment.foodparcel.model.Restaurant;
import com.assignment.foodparcel.payload.FoodItemCO;
import com.assignment.foodparcel.payload.SearchFoodResponseEntity;
import com.assignment.foodparcel.repository.FoodItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<FoodItem> searchByName(String name) {
        List<FoodItem> foodItems = foodItemRepository.findAllByName(name);
        return foodItems;
    }

    public List<FoodItem> searchByNameAndRestaurant(String name, Restaurant restaurant) {
        List<FoodItem> foodItems = foodItemRepository.findAllByNameAndRestaurant(name, restaurant);
        return foodItems;
    }

    public List<SearchFoodResponseEntity> createSearchResponse(List<FoodItem> foodItems) {
        List<SearchFoodResponseEntity> searchFoodResponseEntityList = new ArrayList<>();
        if (foodItems != null) {
            for (FoodItem foodItem : foodItems) {
                SearchFoodResponseEntity searchFoodResponseEntity = new SearchFoodResponseEntity();
                searchFoodResponseEntity.setName(foodItem.getName());
                searchFoodResponseEntity.setDescription(foodItem.getDescription());
                searchFoodResponseEntity.setPrice(foodItem.getPrice());
                Restaurant restaurant = foodItem.getRestaurant();
                searchFoodResponseEntity.setRestaurantName(restaurant.getName());
                searchFoodResponseEntity.setRestaurantPhoneNumber(restaurant.getPhoneNumber());
                searchFoodResponseEntityList.add(searchFoodResponseEntity);
            }
        }
        return searchFoodResponseEntityList;
    }

}
