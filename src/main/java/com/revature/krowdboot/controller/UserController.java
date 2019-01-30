package com.revature.krowdboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.krowdboot.model.User;

import com.revature.krowdboot.service.UserService;

/*
 * UserController maps the endpoints that will be associated with the corresponding get and post 
 * requests that can be received from the client side. 
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/*
	 * getAllUsers maps a get request that corresponds to /user/getallusers. The
	 * method will return a response that contains a list of all of the users in the
	 * database.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
	}

	/*
	 * getUserByUsername will map a get request to the endpoint,
	 * /user/getuserbyusername/{username}. The request will contain a username that
	 * will be used to find that user in the database. If it is a real user, the
	 * method will return a user object associated with that username.
	 */
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.findUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		user.setAccountStatus(0);
		userService.createUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
