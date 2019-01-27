package com.revature.krowdboot.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping(value="/getuserbyid")
	public ResponseEntity<User> getUserById(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		int id = js.getInt("id");
		return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
	}
	
}
