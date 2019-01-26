package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.UserRepository;

@Service("userService")
public class UserService {
	
	
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	
	
	public void deleteUserById(int id) {
		userRepository.deleteUserById(id);	}
	
	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}