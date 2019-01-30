package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.User;

/*
 * UserRpository interface highlights the CRUD methods that will be used within the UserService and 
 * AdminService. The methods are associated with the KROWD_USER table.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByAccountStatus(int status);

	public void deleteById(int id);

	public User getById(int id);

	public User findByUsername(String username);

}
