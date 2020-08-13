package com.assignment.foodparcel.controller;

import com.assignment.foodparcel.model.FoodItem;
import com.assignment.foodparcel.payload.SearchFoodResponseEntity;
import com.assignment.foodparcel.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/search")
    public ResponseEntity<List<SearchFoodResponseEntity>> searchFood(@RequestParam("name") String name) {
        List<FoodItem> foodItemList = foodService.searchByName(name);
        if (foodItemList == null || foodItemList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        List<SearchFoodResponseEntity> response = foodService.createSearchResponse(foodItemList);
        return new ResponseEntity<List<SearchFoodResponseEntity>>(response, HttpStatus.OK);
    }

}
