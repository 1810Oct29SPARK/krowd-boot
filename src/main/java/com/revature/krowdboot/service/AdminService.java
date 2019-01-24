package com.revature.krowdboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.AdminRepository;

public class AdminService {
	
	private AdminRepository adminRepository;
	
	@Autowired
	public void setAdminRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public User getUserByAccountStatus() {
		return null;
	}
	
	public User getFlaggedUsers() {
		return null;
	}
	
	public User getFlaggedEvents() {
		return null;
	}
	
	public User updateUser() {
		return null;
	}
	
	public User deactivateUser() {
		return null;
	}
	
	

}
