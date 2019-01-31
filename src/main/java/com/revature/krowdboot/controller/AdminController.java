package com.revature.krowdboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.service.AdminService;
import com.revature.krowdboot.service.CommentService;

/**
 * 
 * The controller class that handles the HTTP requests related to admin
 * functions.
 * 
 * @author Unknown
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {

	private AdminService adminService;

	private CommentService commentService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	/**
	 * 
	 * The controller method that returns all flagged comments.
	 * 
	 * @return the comment list
	 */
	@GetMapping(value = "/comments")
	public ResponseEntity<List<Comment>> getFlaggedComments(@RequestHeader(value = "Authorization") String cognito) {
		if (cognito.length() < 100) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
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

	/**
	 * 
	 * The controller method that returns all flagged events.
	 * 
	 * @return the event list
	 */
	@GetMapping(value = "/events")
	public ResponseEntity<List<Event>> getFlaggedEvents(@RequestHeader(value = "Authorization") String cognito) {
		if (cognito.length() < 100) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
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

	/**
	 * 
	 * The controller method that deactivates a user.
	 * 
	 * @param id
	 * @return the deactivated user
	 */
	@PostMapping("/deactivate")
	public ResponseEntity<User> deactivateUser(@RequestBody String id) {
		ResponseEntity<User> response = null;
		JSONObject js = new JSONObject(id);
		int userId = js.getInt("id");
		User u = null;
		try {
			u = adminService.deactivateUser(userId);
			response = new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	/**
	 * 
	 * The controller method that unflags an comment.
	 * 
	 * @param id
	 * @return the unflagged comment
	 */
	@PostMapping("/unflagcomment")
	public ResponseEntity<Comment> unflagComment(@RequestBody String id) {
		JSONObject js = new JSONObject(id);
		int comid = js.getInt("id");
		Comment com = commentService.getCommentById(comid);
		com.setFlag(0);
		commentService.updateComment(com);
		return new ResponseEntity<>(com, HttpStatus.OK);
	}

}
