package com.revature.krowdboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;
	
	public List<Event> findallEvents(){
		List<Event> e= new ArrayList<>();
		e=eventRepository.findAll();
		return e;
	}
	
	public void addEvent(Event event) {
		eventRepository.save(event);
	}
	
	public void deleteEvent(int id) {
		Event e=eventRepository.getOne(id);
		eventRepository.delete(e);
	}
	
	public Event getEventById(int id) {
		Event e=eventRepository.getOne(id);
		return e;
	}
	
	public List<Event>getEventByEventCategory(EventCategory ec){
		List<Event> e=new ArrayList<>();
		eventRepository.getEventByCategoryId(ec);
		return e;
	}
	
	public List<Event>getEventByUser(User u){
		List<Event> e=new ArrayList<>();
		eventRepository.getEventByUserId(u);
		return e;
	}
}
	


