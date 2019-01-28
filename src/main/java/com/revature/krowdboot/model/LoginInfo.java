package com.revature.krowdboot.model;

public class LoginInfo extends UserInfo {

	private Boolean newPasswordRequired = false;

	public LoginInfo(String userName, String emailAddr, String location) {
		super(userName, emailAddr, location);
	}

	public LoginInfo(final UserInfo info) {
		this(info.getUserName(), info.getEmailAddr(), info.getLocation());
	}

	public Boolean getNewPasswordRequired() {
		return newPasswordRequired;
	}

	public void setNewPasswordRequired(Boolean newPasswordRequired) {
		this.newPasswordRequired = newPasswordRequired;
	}

}
