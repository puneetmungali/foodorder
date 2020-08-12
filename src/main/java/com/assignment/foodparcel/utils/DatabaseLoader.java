package com.assignment.foodparcel.utils;

import com.assignment.foodparcel.model.User;
import com.assignment.foodparcel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("******** Running database loader ***********");
        createUser();
        logger.info("******* Database loader execution finished **********");
    }

    private void createUser() {
        User user = new User();
        user.setUsername("puneetmungali");
        user.setName("Puneet Mungali");
        user.setPhoneNumber("0987654321");
        user.setEmailId("puneetmungali93@gmail.com");
        userService.save(user);
    }
}
