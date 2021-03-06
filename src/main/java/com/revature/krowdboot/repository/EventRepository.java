package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;

/*
 * @Author Jonathan Snider & Stewart Gardner
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	public List<Event> getEventsByCategoryId(EventCategory category);

	public List<Event> getEventsByUserId(User user);

	public List<Event> getEventsByFlag(int flag);

}
