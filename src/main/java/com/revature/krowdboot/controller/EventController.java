package com.revature.krowdboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.krowdboot.repository.EventRepository;
import com.revature.krowdboot.service.EventService;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;

@RestController
@RequestMapping(value="/event")
public class EventController {

	private EventService es;
	
	@Autowired
	public void setEventRepository(EventService es) {
		this.es = es;
	}
	
	@GetMapping("/all")
	public ResponseEntity<String> string(){
		return new ResponseEntity<>("Fuck", HttpStatus.OK);
//	public ResponseEntity<List<Event>> getAllEvents(){
//		return new ResponseEntity<>(es.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public void addEvent(@RequestBody Event event){
		es.save(event);
	}
	
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestBody Event event) {
		es.delete(event);
	}
	
//	@PutMapping("/update")
//	public void updateEvent(@PathVariable Event event){
//		
//	}
	
	
	@GetMapping("/byId/{eventId}")
	public ResponseEntity<Event> getEventByEventId(@PathVariable int eventId){
		return new ResponseEntity<Event>(es.getOne(eventId), HttpStatus.OK);
	}
	
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<List<Event>> getEventByEventCategory(@PathVariable int categoryId){
		return new ResponseEntity<List<Event>>(es.getEventByCategoryId(new EventCategory(categoryId, null)), HttpStatus.OK);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Event>> getEventByUser(@PathVariable int userId){
		return new ResponseEntity<List<Event>>(es.getEventByUserId(new User(userId)), HttpStatus.OK);
	}
	
}
