package com.assignment.foodparcel.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchFoodResponseEntity {

    private String name;
    private String description;
    private Float price;
    private String restaurantName;
    private String restaurantPhoneNumber;

}
