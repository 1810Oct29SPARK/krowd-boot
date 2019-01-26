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
	public void addEvent(@RequestBody String jsonStr) {//@RequestBody String name,@RequestBody String picture,@RequestBody String description,@RequestBody String date,@RequestBody Integer score,@RequestBody Integer flag,@RequestBody Integer categoryId,@RequestBody Integer userId,@RequestBody String streetAddress,@RequestBody String apartment,@RequestBody String city,@RequestBody String state,@RequestBody Integer zipCode ){
//		boolean inList =false;
		JSONObject json = new JSONObject(jsonStr);
		es.addEvent(json);
//		System.out.println(name);
//		System.out.println(" THIS IS THE USER ID: "+userId);
//		User u=us.getUserById(userId);
//		EventCategory ec=ecs.getCategoryById(categoryId);
//		Address a=new Address(streetAddress,apartment,city,state,zipCode);
//		List<Address> al= as.getAllAddresses();
//		for(Address addressInList : al){
//			if(a==addressInList){
//				inList=true;
//			}
//		}
//		if(inList){
//			as.addAddress(a);
//		}
//		Event e=new Event(name,picture,description,date,a,score,flag,ec,u);
	}
	
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestBody Integer id) {
		es.deleteEvent(id);
	}
	
//	@PutMapping("/update")
//	public void updateEvent(@PathVariable Event event){
//		
//	}
	
	
	@GetMapping("/byId/{eventId}")
	public ResponseEntity<Event> getEventByEventId(@PathVariable Integer eventId){
		return new ResponseEntity<Event>(es.getEventById(eventId), HttpStatus.OK);
	}
	
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<List<Event>> getEventsByEventCategory(@PathVariable Integer categoryId){
		return new ResponseEntity<List<Event>>(es.getEventsByEventCategory(categoryId), HttpStatus.OK);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Event>> getEventsByUser(@PathVariable Integer userId){
		return new ResponseEntity<List<Event>>(es.getEventsByUser(userId), HttpStatus.OK);
	}
	
}
