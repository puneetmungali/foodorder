package com.assignment.foodparcel.service;

import com.assignment.foodparcel.model.User;
import com.assignment.foodparcel.payload.UserCO;
import com.assignment.foodparcel.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private User save(User user) {
        return userRepository.save(user);
    }

    private void delete(User user) {
        userRepository.delete(user);
    }

    public User createUser(UserCO userCO) {
        User user = new User();
        user.setEmailId(userCO.getEmailId());
        user.setName(userCO.getName());
        user.setUsername(userCO.getUsername());
        user.setPhoneNumber(userCO.getPhoneNumber());
        user.setRestaurantOwner(userCO.isRestaurantOwner());
        return save(user);
    }

    public boolean userExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }
}
