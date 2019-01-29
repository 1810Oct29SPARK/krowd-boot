package com.revature.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;

public class UserEventTest extends TestSetup {

    @Test
    public void getAllUsersByEventIdTest() {
        RestAssured.get("/userEvent/userByEvent/1").then().assertThat().body("size()",equalTo(6));
    }
    
    @Test
    public void getAllEventsByUserIdTest() {
    	RestAssured.get("/userEvent/eventByUser/1").then().assertThat()
    	.body("size()", equalTo(6));
    }
    
    @Test
    public void addUserEventTest() {
    //	RestAssured.get("/userEvent/scoreEvent/1").then().assertThat().body(containsString("firstname"));
    }
    
    @Test
    public void getScoreTest() {
        RestAssured.get("/userEvent/scoreEvent/1").then().assertThat().body(containsString("4"));
    }
    
    @Test
    public void rateEventTest() {
    //	RestAssured.get("/user/all").then().assertThat()
    //	.body("size()", equalTo(3));
    }
    
    @Test
    public void getReputationTest() {
    	RestAssured.get("/userEvent/getReputation/1").then().assertThat().body(containsString("21"));
    }
}
