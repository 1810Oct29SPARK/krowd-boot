package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByAccountStatus(int status);
	
	public List<User> findAll();
	
	public void deleteUserById(int id);
	
	public User getUserById(int id);
	
	public User findByUsername(String username);

}
