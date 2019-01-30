package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.EventCategory;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {

}
