package com.assignment.foodparcel.repository;

import com.assignment.foodparcel.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootItemRepository extends JpaRepository<FoodItem, Long> {
}
