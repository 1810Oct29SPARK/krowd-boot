package com.revature.krowdboot.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getuserbyid", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		int id = js.getInt("id");
		return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getuserbyusername", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByUsername(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		String username = js.getString("username");
		return new ResponseEntity<>(userService.findUserByUsername(username),HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteuser", method = RequestMethod.POST)
	public void deleteUserById(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		int id = js.getInt("id");
		userService.deleteUserById(id);
	}
}
