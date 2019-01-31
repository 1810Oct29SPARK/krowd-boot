package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.UserRepository;

/**
 * 
 * UserService defines the methods that will be used within the controllers that
 * will access the database and either retrieve or delete entries associated
 * with the KROWD_USER table.
 * 
 * @author Unknown
 *
 */
@Service("userService")
public class UserService {

	private UserRepository userRepository;

	/**
	 * 
	 * setUserRepository is simply a setter method that will initialize the
	 * UserRepository.
	 * 
	 * @param userRepository
	 */
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * 
	 * findAllUsers will use the UserRepository method, findAll, that returns a list
	 * of all of the users in the database.
	 * 
	 * @return the user list
	 */
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * 
	 * deleteUserById will use the UserRepository method, deleteById, that will
	 * delete the user with that id from the database.
	 * 
	 * @param the deleted user ID
	 */
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	/**
	 * 
	 * getUserById will use the UserRepository method, getById, that returns the
	 * user associated with that id.
	 * 
	 * @param id
	 * @return the user
	 */
	public User getUserById(int id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	/**
	 * 
	 * fineUserByUsername will use the UserRepository method, findByUsername, that
	 * returns the user that is associated with the corresponding username.
	 * 
	 * @param username
	 * @return the user
	 */
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/**
	 * 
	 * The method that registers and saves a new user in the DB.
	 * 
	 * @param user
	 */
	public void createUser(User user) {
		userRepository.save(user);
	}

	/**
	 * 
	 * The method that updates a user.
	 * 
	 * @param user
	 * @return the user's ID
	 */
	public int updateUser(User user) {
		User u = userRepository.save(user);
		if (u != null) {
			return u.getId();
		} else {
			return 0;
		}
	}

}
