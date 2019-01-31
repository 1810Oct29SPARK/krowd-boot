package com.revature.krowdboot.controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

/**
 * @Author Jake Mulrenin
 */
public class TestSetup {
	
	@LocalServerPort
	private int port;
	
	@Before
	public void setUp() throws Exception {
	    RestAssured.port = port;
	}

	@BeforeClass
	public static void setup() {
		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(8085);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://localhost";
		}
		RestAssured.baseURI = baseHost;

	}

}
