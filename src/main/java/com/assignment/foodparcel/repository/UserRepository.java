package com.assignment.foodparcel.repository;

import com.assignment.foodparcel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
