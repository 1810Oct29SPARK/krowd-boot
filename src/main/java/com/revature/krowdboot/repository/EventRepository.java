package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	public List<Event> getEventsByFlag(int flag);
	
}
