package com.revature.krowdboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

/**
 * @Author Jake Mulrenin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	@Test
	public void basicPingTest() {
		RestAssured.get("/user/all").then().statusCode(200);
	}

	@Test
	public void getAllUsersTest() {
		RestAssured.get("/user/all").then().assertThat().body("size()", equalTo(10));
	}

	@Test
	public void getUserById1Test() {
		RestAssured.get("/user/users/1").then().assertThat().body(containsString("Grandmother"));
	}

}
