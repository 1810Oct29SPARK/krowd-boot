package com.revature.test;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestSetup {

	@BeforeClass
	public static void setup() {

		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(8085);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

//	        String basePath = System.getProperty("server.base");
//	        if(basePath==null){
//	            basePath = "/rest-garage-sample/";
//	        }
//	        RestAssured.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://localhost";
		}
		RestAssured.baseURI = baseHost;

	}

}
