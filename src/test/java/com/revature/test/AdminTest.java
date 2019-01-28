package com.revature.test;

import org.junit.Test;

import com.revature.krowdboot.model.User;

import io.restassured.RestAssured;

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
    	RequestSpecification sendRequest = RestAssured.given();
    	JSONObject request = new JSONObject();
    	request.put("user","{\"id\":1,\"email\":\"email@email.com\",\"firstname\":\"Arv\",\"lastname\":\"lastname\",\"username\":\"username\",\"picture\":\"picture\",\"reputation\":1234,\"accountStatus\":1}");
   		request.put("id", 1);
    	request.put("email","email@email.com");
    	request.put("firstname","Alex");
    	request.put("lastname","lastname");
    	request.put("username","username");
    	request.put("picture","picture");
    	request.put("reputation",1234);
    	request.put("accountStatus", 1);
    	// Add a header stating the Request body is a JSON
    	sendRequest.header("Content-Type", "application/json");
    	sendRequest.body(request.toJSONString());
    	 Response response = sendRequest.put("/admin/update"); 
    	 int statusCode = response.getStatusCode();
    	 Assert.assertEquals(statusCode, 200);
    }
*/
    @Test
    public void deactivateUserTest() {
/*    	RequestSpecification sendRequest = RestAssured.given();
    	JSONObject request = new JSONObject();
    	request.put("id", 1);
    	sendRequest.header("Content-Type", "application/json");
    	sendRequest.body(request.toJSONString());
    	 Response response = sendRequest.post("/admin/deactivate"); 
    	 int statusCode = response.getStatusCode();
    	 Assert.assertEquals(statusCode, 200);*/
        RestAssured.with().body(new User(1,"email@email.com","firstname","lastname","username","picture",1234,0))
        .when()
        .request("POST", "/admin/deactivate")
        .then()
        .statusCode(200);
    }
    
}
