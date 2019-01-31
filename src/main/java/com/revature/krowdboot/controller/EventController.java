package com.revature.krowdboot.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.service.EventService;

/**
 * 
 * The controller class that handles the HTTP requests related to events.
 * 
 * @Author Jonathan Snider & Stewart Gardner
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	private EventService es;

	@GetMapping("/all")
	public ResponseEntity<List<Event>> getAllEvents() {
		return new ResponseEntity<>(es.findallEvents(), HttpStatus.OK);
	}

	/**
	 * 
	 * The controller method that creates a new event.
	 * 
	 * @param jsonStr
	 */
	@PostMapping("/add")
	public void addEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		es.addEvent(json);
	}

<<<<<<< HEAD
	@DeleteMapping("/delete/{id}")
	public void deleteEvent(@PathVariable String id) {
		int ID = Integer.parseInt(id);
		es.deleteEvent(ID);
=======
	/**
	 * 
	 * The controller method that deletes an event.
	 * 
	 * @param jsonStr
	 */
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		int id = json.getInt("id");
		es.deleteEvent(id);
>>>>>>> 6ce2b7c714382e29b49c2f993513413538805f7b
	}

	/**
	 * 
	 * The controller method that updates an event.
	 * 
	 * @param jsonStr
	 */
	@PutMapping("/update")
	public void updateEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		es.updateEvent(json);
	}

	/**
	 * 
	 * The controller method that retrieves and returns an event based on its ID.
	 * 
	 * @param eventId
	 * @return
	 */
	@GetMapping("/byId/{eventId}")
	public ResponseEntity<Event> getEventByEventId(@PathVariable String eventId) {
		Integer eventNumber = Integer.parseInt(eventId);
		return new ResponseEntity<Event>(es.getEventById(eventNumber), HttpStatus.OK);
	}

	/**
	 * 
	 * The controller method that returns all events of a specific category.
	 * 
	 * @param categoryId
	 * @return the event list
	 */
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<List<Event>> getEventsByEventCategory(@PathVariable String categoryId) {
		Integer categoryNumber = Integer.parseInt(categoryId);
		return new ResponseEntity<List<Event>>(es.getEventsByEventCategory(categoryNumber), HttpStatus.OK);
	}

	/**
	 * 
	 * The controller method that returns all events created by a specific user.
	 * 
	 * @param userId
	 * @return the event list
	 */
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Event>> getEventsByUser(@PathVariable Integer userId) {
		return new ResponseEntity<List<Event>>(es.getEventsByUser(userId), HttpStatus.OK);
	}

	/**
	 * 
	 * The controller method that returns all flagged events.
	 * 
	 * @return the event list
	 */
	@GetMapping("/byFlag")
	public ResponseEntity<List<Event>> getEventsByFlag() {
		return new ResponseEntity<List<Event>>(es.getEventsByFlag(), HttpStatus.OK);
	}

}
