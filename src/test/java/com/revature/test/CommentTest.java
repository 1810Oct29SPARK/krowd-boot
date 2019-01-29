package com.revature.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import com.revature.krowdboot.model.Comment;

import io.restassured.RestAssured;

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
    //    RestAssured.get("/user/all").then().statusCode(200);
    }
    
    @Test
    public void createCommentTest() {
    //	RestAssured.get("/user/all").then().assertThat()
    //	.body("size()", equalTo(3));
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
