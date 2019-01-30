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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @Author Jake Mulrenin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CommentControllerTest {

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	@Test
	public void getAllCommentsTest() {
		RestAssured.get("/comment/getallcomments").then().assertThat().body("size()", equalTo(10));
	}

	@Test
	public void getCommentByIdTest() {
		RestAssured.get("/comment/getById/1").then().assertThat()
				.body(containsString("Looking forward to seeing all you."));
	}

	@Test
	public void getCommentByFlagTest() {
		RestAssured.get("/comment/getByFlag/1").then().assertThat().body("size()", equalTo(2));
	}

	@Test
	public void deleteCommentTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		JsonObject request = new JsonObject();
		request.addProperty("id", 2);
		httpRequest.body(request.toString());
		Response response = httpRequest.post("/comment/deletecomment");
		Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void createCommentTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		JsonObject request = new JsonObject();
		request.addProperty("comment", "Laughable");
		request.addProperty("userId", 1);
		request.addProperty("eventId", 1);
		httpRequest.body(request.toString());
		Response response = httpRequest.post("/comment/createcomment");
		Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void flagCommentTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		JsonObject request = new JsonObject();
		request.addProperty("id", 1);
		httpRequest.body(request.toString());
		Response response = httpRequest.post("/comment/flagcomment");
		Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void unflagCommentTest() {
		// RestAssured.get("/user/users/1").then().assertThat().body(containsString("firstname"));
	}

}
