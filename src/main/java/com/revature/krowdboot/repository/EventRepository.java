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
	public List<Event> getEventByCategoryId(int id);
	//not sure at the moment how the above and below methods interact with mappings to other tables
	public List<Event> getEventByUserId(User u);
	
=======
	public List<Event> getEventsByFlag(int flag);
>>>>>>> 40361158a5b89647a34d47b42dce33bd93232741
	
}
