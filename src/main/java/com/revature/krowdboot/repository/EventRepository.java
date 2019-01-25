package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
<<<<<<< HEAD
	public List<Event> allEvents();
	//public void addEvent(Event e);
	public void updateEvent(Event e);
	public void deleteEventById(int id);
	public Event getEventById(int id);
=======
>>>>>>> aa5393bdfe48488742b771eee05869894e0148eb
	public List<Event> getEventByCategoryId(EventCategory ec);
	//not sure at the moment how the above and below methods interact with mappings to other tables
	public List<Event> getEventByUserId(User u);
	
	
}
