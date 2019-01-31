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
import io.restassured.http.Header;

/**
 * @Author Jake Mulrenin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	Header token = new Header("Authorization", "gjahdnsandhfajdfjue73845yhrgh8483t4hfuhduhfdsagfy476ru4guhusghurauyfeq7hrqeyfgudhasyfsq73ygqryfgu8ydgvduqfhgyrq8gf8uqherfugq87yghdbjkvucdsagijngfuewhguiwn8rugy74uh43iutrh8rt7ah");

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	@Test
	public void basicPingTest() {
		RestAssured.given().header(token).get("/user/all").then().statusCode(200);
	}

	@Test
	public void getAllUsersTest() {
		RestAssured.given().header(token).get("/user/all").then().assertThat().body("size()", equalTo(10));
	}

	@Test
	public void getUserById1Test() {
		RestAssured.given().header(token).get("/user/users/1").then().assertThat().body(containsString("Grandmother"));
	}

}
