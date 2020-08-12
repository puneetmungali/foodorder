package com.assignment.foodparcel.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCO {

    private String username;
    private String name;
    private String phoneNumber;
    private String emailId;
    private boolean isRestaurantOwner = Boolean.FALSE;

}
