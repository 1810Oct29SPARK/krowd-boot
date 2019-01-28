package com.revature.krowdboot.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RestController
@RequestMapping(value = "/event")
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
	public ResponseEntity<List<Event>> getAllEvents() {
		return new ResponseEntity<>(es.findallEvents(), HttpStatus.OK);
	}

	@PreAuthorize("hasRole(1)")
	@PostMapping("/add")
	public void addEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		es.addEvent(json);
	}

	@PreAuthorize("hasRole(2)")
	@DeleteMapping("/delete")
	public void deleteEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		Integer id = Integer.parseInt((String) json.get("id"));
		es.deleteEvent(id);
	}

	@PreAuthorize("hasRole(1)")
	@PutMapping("/update")
	public void updateEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		es.updateEvent(json);
	}

	@GetMapping("/byId/{eventId}")
	public ResponseEntity<Event> getEventByEventId(@PathVariable String eventId) {
		Integer eventNumber = Integer.parseInt(eventId);
		return new ResponseEntity<Event>(es.getEventById(eventNumber), HttpStatus.OK);
	}

	@PreAuthorize("hasRole(1)")
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<List<Event>> getEventsByEventCategory(@PathVariable String categoryId) {
		Integer categoryNumber = Integer.parseInt(categoryId);
		return new ResponseEntity<List<Event>>(es.getEventsByEventCategory(categoryNumber), HttpStatus.OK);
	}

	@PreAuthorize("hasRole(1)")
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Event>> getEventsByUser(@PathVariable Integer userId) {
		return new ResponseEntity<List<Event>>(es.getEventsByUser(userId), HttpStatus.OK);
	}

	@PreAuthorize("hasRole(2)")
	@GetMapping("/byFlag")
	public ResponseEntity<List<Event>> getEventsByFlag() {
		return new ResponseEntity<List<Event>>(es.getEventsByFlag(), HttpStatus.OK);
	}

}
