package com.assignment.foodparcel.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodItemCO {

    private String name;
    private String description;
    private Float price;
    private String restaurantId;

}
