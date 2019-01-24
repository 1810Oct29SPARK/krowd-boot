package com.revature.krowd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowd.bean.EventCategory;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {

}
