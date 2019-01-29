package com.revature.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommentTest extends TestSetup{

    @Test
    public void getAllCommentsTest() {
        RestAssured.get("/comment/getallcomments").then().assertThat()
        .body("size()", equalTo(10));
    }
    
    @Test
    public void getCommentByIdTest() {
    	RestAssured.get("/comment/getById/1").then().assertThat()
    	.body(containsString("Looking forward to seeing all you."));
    }
    
    @Test
    public void getCommentByFlagTest() {
    	RestAssured.get("/comment/getByFlag/1").then().assertThat().body("size()",equalTo(3));
    }
    
    @Test
    public void deleteCommentTest() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        request.addProperty("id", 2);
        httpRequest.body(request.toString());
        Response response = httpRequest.post("/comment/deletecomment");
        Assert.assertEquals(response.statusCode(), 200);
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
        Assert.assertEquals(response.statusCode(), 200);
    }
    
    @Test
    public void flagCommentTest() {
    //	RestAssured.get("/user/users/1").then().assertThat().body(containsString("firstname"));
    }
    
    @Test
    public void unflagCommentTest() {
    //	RestAssured.get("/user/users/1").then().assertThat().body(containsString("firstname"));
    }
}
