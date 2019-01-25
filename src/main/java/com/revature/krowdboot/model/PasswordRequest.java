package com.revature.krowdboot.model;

public class PasswordRequest {

	public PasswordRequest(String userName, String oldPassword, String newPassword) {
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	private final String userName;
	private final String oldPassword;
	private final String newPassword;

	public String getUserName() {
		return userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

}
