package com.revature.krowdboot.model;

public class UserInfo {

	public UserInfo(String userName, String emailAddr, String location) {
		this.userName = userName;
		this.emailAddr = emailAddr;
		this.location = location;
	}

	private final String userName;
	private final String emailAddr;
	private final String location;

	public String getUserName() {
		return userName;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public String getLocation() {
		return location;
	}

}
