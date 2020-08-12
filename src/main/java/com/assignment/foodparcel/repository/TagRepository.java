package com.assignment.foodparcel.repository;

import com.assignment.foodparcel.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
