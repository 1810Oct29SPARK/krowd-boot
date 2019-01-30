package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.EventCategory;

/**
 * 
 * The repository interface that serves as the data access object for the
 * EventCategory class.
 * 
 * @author Jonathan Snider & Stewart Gardner
 *
 */
@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
}
