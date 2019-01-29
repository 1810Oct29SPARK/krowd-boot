package com.revature.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;

public class UserEventTest extends TestSetup {

    @Test
    public void getAllUsersByEventIdTest() {
    //    RestAssured.get("/user/all").then().statusCode(200);
    }
    
    @Test
    public void getAllEventsByUserIdTest() {
    //	RestAssured.get("/user/all").then().assertThat()
    //	.body("size()", equalTo(3));
    }
    
    @Test
    public void addUserEventTest() {
    //	RestAssured.get("/user/users/1").then().assertThat().body(containsString("firstname"));
    }
    
    @Test
    public void getScoreTest() {
    //    RestAssured.get("/user/all").then().statusCode(200);
    }
    
    @Test
    public void rateEventTest() {
    //	RestAssured.get("/user/all").then().assertThat()
    //	.body("size()", equalTo(3));
    }
    
    @Test
    public void getReputationTest() {
    //	RestAssured.get("/user/users/1").then().assertThat().body(containsString("firstname"));
    }
}
