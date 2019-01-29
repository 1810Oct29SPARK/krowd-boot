package com.revature.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.revature.krowdboot.model.Event;

import io.restassured.RestAssured;

public class EventTest extends TestSetup{

    @Test
    public void getAllEventsTest() {
    	RestAssured.get("/event/all").then().statusCode(200);
    }
    
/*    @Test
    public void addEventTest() {
    	RestAssured.get("/user/all").then().assertThat()
    	.body("size()", equalTo(3));
    }
   
    @Test
    public void deleteEventTest() {
    //	RestAssured.get("/user/users/1").then().assertThat().body(containsString("firstname"));
    }
    
    @Test
    public void updateEventTest() {
    //    RestAssured.get("/user/all").then().statusCode(200);
    }
*/ 
    @Test
    public void getEventByEventIdTest() {
    	RestAssured.get("/event/byId/1").then().assertThat()
      .body(containsString("Haunted House Party"));
    }
    
    @Test
    public void getEventsByEventCategoryTest() {
    	RestAssured.get("/event/byCategory/2").then().assertThat().body(containsString("Other"));
    }
    
    @Test
    public void getEventsByUser() {
        RestAssured.get("/event/byUser/2").then().assertThat().body("name",equalTo("Miner 49er"));
    }
    
    @Test
    public void getEventsByFlagTest() {
    	RestAssured.get("/event/byFlag").then().assertThat()
    	.body("size()", equalTo(1));
    }
}
