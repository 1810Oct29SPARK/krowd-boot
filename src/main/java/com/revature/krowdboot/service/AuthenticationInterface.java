package com.revature.krowdboot.service;

import com.revature.krowdboot.model.LoginInfo;
import com.revature.krowdboot.model.PasswordRequest;
import com.revature.krowdboot.model.UserInfo;

public interface AuthenticationInterface {

	void createNewUser(UserInfo userInfo) throws Exception;

	UserInfo findUserByEmailAddr(final String email) throws Exception;

	LoginInfo userLogin(String userName, String password) throws Exception;

	void userLogout(String userName) throws Exception;

	public void changeFromTemporaryPassword(final PasswordRequest passwordRequest) throws Exception;

	UserInfo getUserInfo(String userName) throws Exception;

	boolean hasUser(String userName);

}
