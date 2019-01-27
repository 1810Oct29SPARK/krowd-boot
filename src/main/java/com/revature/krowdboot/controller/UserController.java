/*
 * UserController maps the endpoints that will be associated with the corresponding get and post 
 * requests that can be received from the client side. 
 */
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
	
	/*
	 * getAllUsers maps a get request that corresponds to /user/getallusers. 
	 * The method will return a response that contains a list of all of the 
	 * users in the database.
	 */
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getuserbyid")
	public ResponseEntity<User> getUserById(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		int id = js.getInt("id");
		return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@GetMapping(value="/getuserbyusername")
	public ResponseEntity<User> getUserByUsername(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		String username = js.getString("username");
		return new ResponseEntity<>(userService.findUserByUsername(username),HttpStatus.OK);
	}
	
	/*
	 * The deleteUserById method will map a post request to the endpoint, /user/deleteuser.
	 * The request will contain a user object that will be used with the service method,
	 * deleteUserById, once the id is extracted from the object.
	 */
	@PostMapping(value="/deleteuser")
	public void deleteUserById(@RequestBody String user){
		JSONObject js = new JSONObject(user);
		int id = js.getInt("id");
		userService.deleteUserById(id);
	}
	
}
