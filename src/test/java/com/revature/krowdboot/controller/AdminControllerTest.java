package com.revature.krowdboot.controller;

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
 * @Author: Jake Mulrenin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {

	Header token = new Header("Authorization", "gjahdnsandhfajdfjue73845yhrgh8483t4hfuhduhfdsagfy476ru4guhusghurauyfeq7hrqeyfgudhasyfsq73ygqryfgu8ydgvduqfhgyrq8gf8uqherfugq87yghdbjkvucdsagijngfuewhguiwn8rugy74uh43iutrh8rt7ah");

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	@Test
	public void flaggedCommentsTest() {
		RestAssured.given().header(token).get("/admin/comments").then().statusCode(200);
	}

	@Test
	public void flaggedEventsTest() {
		RestAssured.given().header(token).get("/admin/events").then().statusCode(200);
	}

	/*
	 * deactivateUserTest will ensure that admins are able to deactivate user
	 * accounts. The test begins by initializing an http request and sets the
	 * content type in the header to be JSON data. A JSON object is then created
	 * that includes the id of the user that will be deactivated, in this case 2.
	 * The http request body is then loaded with the JSON object and to the
	 * deactivate endpoint via a post request. The response is then checked to
	 * ensure that the status code is 200, meaning a user was successfully
	 * deactivated.
	 */
	@Test
	public void deactivateUserTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header(token);
		JsonObject request = new JsonObject();
		request.addProperty("id", 2);
		httpRequest.body(request.toString());
		Response response = httpRequest.post("/admin/deactivate");
		Assert.assertEquals(200, response.statusCode());
	}

}
