package com.revature.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.krowdboot.service.UserService;
import io.restassured.RestAssured;

public class UserTest extends TestSetup{
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
    @Test
    public void basicPingTest() {
        RestAssured.get("/user/all").then().statusCode(200);
    }
    
    @Test
    public void getAllUsersTest() {
    	RestAssured.get("/user/all").then().assertThat()
    	.body("size()", equalTo(10));
    }
    
    @Test
    public void getUserById1Test() {
    	RestAssured.get("/user/users/1").then().assertThat().body(containsString("Grandmother"));
    }
}
