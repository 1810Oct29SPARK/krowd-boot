package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.EventCategory;

/*
 * @Author Jonathan Snider & Stewart Gardner
*/

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {

}
