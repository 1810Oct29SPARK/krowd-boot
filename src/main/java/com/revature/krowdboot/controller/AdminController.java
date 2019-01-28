package com.revature.krowdboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.service.AdminService;

@RestController
@CrossOrigin
@PreAuthorize("hasRole(1)")
@RequestMapping(value = "/admin")
public class AdminController {

	private AdminService adminService;

	@GetMapping(value = "/comments")
	public ResponseEntity<List<Comment>> getFlaggedComments() {
		ResponseEntity<List<Comment>> response = null;
		List<Comment> comments = new ArrayList<>();
		try {
			comments = adminService.getFlaggedComments(1);
			response = new ResponseEntity<>(comments, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(comments, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping(value = "/events")
	public ResponseEntity<List<Event>> getFlaggedEvents() {
		ResponseEntity<List<Event>> response = null;
		List<Event> events = new ArrayList<>();
		try {
			events = adminService.getFlaggedEvents(1);
			response = new ResponseEntity<>(events, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(events, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		ResponseEntity<User> response = null;
		User u = null;
		try {
			u = adminService.updateUser(user);
			response = new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping("/deactivate")
	public ResponseEntity<User> deactivateUser(@RequestBody int id) {
		ResponseEntity<User> response = null;
		User u = null;
		try {
			u = adminService.deactivateUser(id);
			response = new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
