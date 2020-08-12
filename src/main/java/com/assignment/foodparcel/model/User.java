package com.assignment.foodparcel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(max = 25)
    private String username;

    @NotNull
    @Size(max = 65)
    private String name;

    @Size(max = 15)
    private String phoneNumber;

    @Email
    @Column(unique = true)
    private String emailId;

    private boolean isRestaurantOwner = Boolean.FALSE;

}
