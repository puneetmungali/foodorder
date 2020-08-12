package com.assignment.foodparcel.repository;

import com.assignment.foodparcel.model.Restaurant;
import com.assignment.foodparcel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    boolean existsByNameAndUser(String name, User user);

    List<Restaurant> getAllByName(String name);
}
