package com.revature.krowdboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.krowdboot.service.EventCategoryService;
import com.revature.krowdboot.service.EventService;
import com.revature.krowdboot.service.UserService;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;

@RestController
@RequestMapping(value="/event")
public class EventController {
	@Autowired
	private EventService es;
	
	@Autowired
	private EventCategoryService ecs;
	
	@GetMapping("/all")
	public ResponseEntity<List<Event>> getAllEvents(){
	return new ResponseEntity<>(es.findallEvents(), HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public void addEvent(@RequestBody int id, String name, String picture, String description, String date, String address, int score, int flag, int categoryId, int userId ){
		EventCategory ec=ecs.getCategoryById(categoryId);
		//Event event=
		//es.addEvent(event);
	}
	
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestBody int id) {
		es.deleteEvent(id);
	}
	
//	@PutMapping("/update")
//	public void updateEvent(@PathVariable Event event){
//		
//	}
	
	
	@GetMapping("/byId/{eventId}")
	public ResponseEntity<Event> getEventByEventId(@PathVariable int eventId){
		return new ResponseEntity<Event>(es.getEventById(eventId), HttpStatus.OK);
	}
	
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<List<Event>> getEventByEventCategory(@PathVariable int categoryId){
		return new ResponseEntity<List<Event>>(es.getEventByEventCategory(categoryId), HttpStatus.OK);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Event>> getEventByUser(@PathVariable int userId){
		return new ResponseEntity<List<Event>>(es.getEventByUser(new User(userId)), HttpStatus.OK);
	}
	
}
