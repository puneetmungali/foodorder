package com.assignment.foodparcel.repository;

import com.assignment.foodparcel.model.FoodItem;
import com.assignment.foodparcel.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findAllByName(String name);

    List<FoodItem> findAllByNameAndRestaurant(String name, Restaurant restaurant);
}
