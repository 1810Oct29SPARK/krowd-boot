package com.revature.test;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.krowdboot.model.User;
import com.revature.krowdboot.service.UserService;

import io.restassured.RestAssured;

public class UserTest {

	private static UserService userService;

	static {
		userService = new UserService();
	}

	@Test
	public void basicPingTest() {
		RestAssured.get("/user/all").then().statusCode(200);
	}

	@Test
	public void getAllUsersTest() {
		RestAssured.get("/user/all").then().assertThat().body("size()", equalTo(10));
	}

	@Ignore
	@Test
	public void getUserById1() {
		User testUser = userService.getUserById(1);
		RestAssured.get("/user/1").then().assertThat().body("user", equalTo(testUser));
	}

}
