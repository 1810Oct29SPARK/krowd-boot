package com.revature.krowdboot.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.service.UserEventService;

@RestController
@RequestMapping(value = "/userEvent")
public class UserEventController {

	private UserEventService ues;

	@Autowired
	public void setUes(UserEventService ues) {
		this.ues = ues;
	}

	@PreAuthorize("hasRole(1)")
	@GetMapping("/userByEvent/{eventId}")
	public ResponseEntity<List<User>> getAllUsersByEventId(@PathVariable String eventId) {
		int eventNumber = Integer.parseInt(eventId);
		return new ResponseEntity<>(ues.findAllUsersByEventId(eventNumber), HttpStatus.OK);
	}

	@PreAuthorize("hasRole(1)")
	@GetMapping("/eventByUser/{userId}")
	public ResponseEntity<List<Event>> getAllEventsByUserId(@PathVariable String userId) {
		int userNumber = Integer.parseInt(userId);
		return new ResponseEntity<>(ues.findAllEventsByUserId(userNumber), HttpStatus.OK);
	}

	@PreAuthorize("hasRole(1)")
	@PostMapping("/addUserEvent")
	public void addUserEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		int eventId = Integer.parseInt((String) json.get("eventId"));
		int userId = Integer.parseInt((String) json.get("userId"));
		ues.addUserEvent(userId, eventId);
	}

	@GetMapping("/scoreEvent/{eventId}")
	public Integer getScore(@PathVariable String eventId) {
		int eId = Integer.parseInt(eventId);
		return ues.calculateEventScore(eId);
	}

	@PreAuthorize("hasRole(1)")
	@PutMapping("/rate")
	public void rateEvent(@RequestBody String jsonStr) {
		JSONObject json = new JSONObject(jsonStr);
		ues.updateUserEvent(json);
	}

	@PreAuthorize("hasRole(1)")
	@GetMapping("/getReputation/{userId}")
	public Integer getReputation(@PathVariable String userId) {
		int userNumber = Integer.parseInt(userId);
		return ues.calculateReputation(userNumber);
	}
}
