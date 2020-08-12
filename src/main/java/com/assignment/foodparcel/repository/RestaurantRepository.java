package com.assignment.foodparcel.repository;

import com.assignment.foodparcel.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
