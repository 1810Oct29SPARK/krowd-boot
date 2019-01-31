package com.revature.krowdboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @Author Jake Mulrenin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserEventControllerTest {

	Header token = new Header("Authorization", "gjahdnsandhfajdfjue73845yhrgh8483t4hfuhduhfdsagfy476ru4guhusghurauyfeq7hrqeyfgudhasyfsq73ygqryfgu8ydgvduqfhgyrq8gf8uqherfugq87yghdbjkvucdsagijngfuewhguiwn8rugy74uh43iutrh8rt7ah");

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	@Test
	public void getAllUsersByEventIdTest() {
		RestAssured.given().header(token).get("/userEvent/userByEvent/1").then().assertThat().body("size()", equalTo(10));
	}

	@Test
	public void getAllEventsByUserIdTest() {
		RestAssured.given().header(token).get("/userEvent/eventByUser/1").then().assertThat().body("size()", equalTo(10));
	}

	@Test
	public void addUserEventTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header(token);
		JsonObject request = new JsonObject();
		request.addProperty("userId", 10);
		request.addProperty("eventId", 3);
		httpRequest.body(request.toString());
		Response response = httpRequest.post("/userEvent/addUserEvent");
		Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void getScoreTest() {
		RestAssured.given().header(token).get("/userEvent/scoreEvent/1").then().assertThat().body(containsString("4"));
	}

	@Test
	public void rateEventTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header(token);
		JsonObject request = new JsonObject();
		request.addProperty("userId", 10);
		request.addProperty("eventId", 1);
		request.addProperty("rating", 1);
		httpRequest.body(request.toString());
		Response response = httpRequest.put("/userEvent/rate");
		Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void getReputationTest() {
		RestAssured.given().header(token).get("/userEvent/getReputation/1").then().assertThat().body(containsString("21"));
	}

}
