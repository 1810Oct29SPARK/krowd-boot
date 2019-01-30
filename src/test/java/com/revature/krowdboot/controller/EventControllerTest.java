/**
 * @Author Jake Mulrenin
 */

package com.revature.krowdboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.JsonObject;
import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EventControllerTest extends TestSetup{

    @Test
    public void getAllEventsTest() {
    	RestAssured.get("/event/all").then().statusCode(200);
    }
    
    @Test
    public void addEventTest() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        request.addProperty("eventName","Bradley's");
        request.addProperty("eventPhotoID","photo");
        request.addProperty("eventDescription","Social Get-Together");
        request.addProperty("eventDate","February 1, 2019");
        request.addProperty("userID",3);
        request.addProperty("eventCategory",6);
        request.addProperty("eventAddress","1111 Ybor Road");
        request.addProperty("eventApartment","Bradley's");
        request.addProperty("eventCity","Tampa");
        request.addProperty("eventState","Florida");
        request.addProperty("eventZip",33615);
        httpRequest.body(request.toString());
        Response response = httpRequest.post("/event/add");
        Assert.assertEquals(200, response.statusCode());
    }
   
    @Test
    public void deleteEventTest() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        request.addProperty("id",1);
        httpRequest.body(request.toString());
        Response response = httpRequest.delete("/event/delete");
        Assert.assertEquals(200, response.statusCode());
    }
    
    @Test
    public void updateEventTest() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        request.addProperty("eventID", 9);
        request.addProperty("eventName","Beach Party");
        request.addProperty("eventPhotoID","photo");
        request.addProperty("eventDescription","Social Get-Together");
        request.addProperty("eventDate","February 1, 2019");
        request.addProperty("eventFlag", 0);
        request.addProperty("userID",3);
        request.addProperty("eventCategory",6);
        request.addProperty("eventAddress","1111 Ybor Road");
        request.addProperty("eventApartment","Bradley's");
        request.addProperty("eventCity","Tampa");
        request.addProperty("eventState","Florida");
        request.addProperty("eventZip",33615);
        httpRequest.body(request.toString());
        Response response = httpRequest.put("/event/update");
        Assert.assertEquals(200, response.statusCode());
    }
 
    @Test
    public void getEventByEventIdTest() {
    	RestAssured.get("/event/byId/2").then().assertThat()
      .body(containsString("Arts and Crafts with Grandma"));
    }
    
    @Test
    public void getEventsByEventCategoryTest() {
    	RestAssured.get("/event/byCategory/2").then().assertThat().body(containsString("Learn to Bake"));
    }
    
    @Test
    public void getEventsByUser() {
        RestAssured.get("/event/byUser/2").then().assertThat().body(containsString("Hike near Hillsborough"));
    }
    
    @Test
    public void getEventsByFlagTest() {
    	RestAssured.get("/event/byFlag").then().assertThat()
    	.body("size()", equalTo(1));
    }
}
