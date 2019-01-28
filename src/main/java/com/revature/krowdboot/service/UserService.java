package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.UserRepository;

/*
 * UserService defines the methods that will be used within the controllers that will access 
 * the database and either retrieve or delete entries associated with the KROWD_USER table. 
 */
@Service("userService")
public class UserService {

	private UserRepository userRepository;

	/*
	 * setUserRepository is simply a setter method that will initialize the
	 * UserRepository.
	 */
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	 * findAllUsers will use the UserRepository method, findAll, that returns a list
	 * of all of the users in the database.
	 */
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	/*
	 * deleteUserById will use the UserRepository method, deleteById, that will
	 * delete the user with that id from the database.
	 */
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	/*
	 * getUserById will use the UserRepository method, getById, that returns the
	 * user associated with that id.
	 */
	public User getUserById(int id) {
		return userRepository.getById(id);
	}

	/*
	 * fineUserByUsername will use the UserRepository method, findByUsername, that
	 * returns the user that is associated with the corresponding username.
	 */
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
