package com.revature.krowdboot.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.krowdboot.service.AddressService;
import com.revature.krowdboot.service.EventCategoryService;
import com.revature.krowdboot.service.EventService;
import com.revature.krowdboot.service.UserService;
import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;

@RestController
@RequestMapping(value="/event")
public class EventController {
	@Autowired
	private EventService es;
//	@Autowired
//	private UserService us;
//	@Autowired
//	private EventCategoryService ecs;
//	@Autowired
//	private AddressService as;
	
	@GetMapping("/all")
	public ResponseEntity<List<Event>> getAllEvents(){
	return new ResponseEntity<>(es.findallEvents(), HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public void addEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		es.addEvent(json);
	}
	
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		Integer id = Integer.parseInt((String)json.get("id"));
		es.deleteEvent(id);
	}
	
	@PutMapping("/update")
	public void updateEvent(@RequestBody String jsonStr){
		JSONObject json = new JSONObject(jsonStr);
		es.updateEvent(json);
	}
	
	
	@GetMapping("/byId/{eventId}")
	public ResponseEntity<Event> getEventByEventId(@PathVariable String eventId){
		Integer eventNumber=Integer.parseInt(eventId);
		return new ResponseEntity<Event>(es.getEventById(eventNumber), HttpStatus.OK);
	}
	
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<List<Event>> getEventsByEventCategory(@PathVariable String categoryId){
		Integer categoryNumber=Integer.parseInt(categoryId);
		return new ResponseEntity<List<Event>>(es.getEventsByEventCategory(categoryNumber), HttpStatus.OK);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Event>> getEventsByUser(@PathVariable Integer userId){
		return new ResponseEntity<List<Event>>(es.getEventsByUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/byFlag")
	public ResponseEntity<List<Event>> getEventsByFlag(){
		return new ResponseEntity<List<Event>>(es.getEventsByFlag(), HttpStatus.OK);
	}
	
	
}