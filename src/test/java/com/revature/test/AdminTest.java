package com.revature.test;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.revature.krowdboot.model.User;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AdminTest extends TestSetup {
	
    @Test
    public void flaggedCommentsTest() {
        RestAssured.get("/admin/comments").then().statusCode(200);
    }
    
    @Test
    public void flaggedEventsTest() {
        RestAssured.get("/admin/events").then().statusCode(200);
    }
    
/*    @Test
    public void UpdateUserTest() {
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            JsonObject request = new JsonObject();
            request.addProperty("id", 2);
            request.addProperty("email", "shepherd@lamb.com");
            request.addProperty("firstname", "Bo");
            request.addProperty("lastname", "Peep");
            request.addProperty("username", "BoPeep");
            request.addProperty("picture", "https://upload.wikimedia.org/wikipedia/commons/6/66/Hambledon_Hill_Sheep.jpg");
            request.addProperty("reputation", 87);
            request.addProperty("accountStatus", 1);
            httpRequest.body(request.toString());
            Response response = httpRequest.post("/admin/deactivate");
            Assert.assertEquals(response.statusCode(), 200);
    }
*/
    /*
     * deactivateUserTest will ensure that admins are able to deactivate user accounts.
     * The test begins by initializing an http request and sets the content type in the
     * header to be JSON data. A JSON object is then created that includes the id 
     * of the user that will be deactivated, in this case 2. The http request body 
     * is then loaded with the JSON object and to the deactivate endpoint via a post 
     * request. The response is then checked to ensure that the status code is 200, 
     * meaning a user was successfully deactivated.
     */
    @Test
    public void deactivateUserTest() {
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            JsonObject request = new JsonObject();
            request.addProperty("id", 2);
            httpRequest.body(request.toString());
            Response response = httpRequest.post("/admin/deactivate");
            Assert.assertEquals(response.statusCode(), 200);
    }
    
}
