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
@PreAuthorize("hasRole(2)")
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
		return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	}

	/*
	 * getUserById will map a get request to the endpoint,
	 * /user/getuserbyid/{requestid}. The request will contain an int that will be
	 * associated with their id. If their id is a real id within the database, the
	 * method will return the user associated with that id.
	 */
	@GetMapping(value = "/{requestid}")
	public ResponseEntity<User> getUserById(@PathVariable String requestId) {
		int id = Integer.parseInt(requestId);
		return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
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

	/*
	 * The deleteUserById method will map a post request to the endpoint,
	 * /user/deleteuser. The request will contain a user object that will be used
	 * with the service method, deleteUserById, once the id is extracted from the
	 * object.
	 */
	@PostMapping(value = "/delete")
	public void deleteUserById(@RequestBody String user) {
		JSONObject js = new JSONObject(user);
		int id = js.getInt("id");
		userService.deleteUserById(id);
	}

}
