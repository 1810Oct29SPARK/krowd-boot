package com.revature.krowdboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * The main class that launches the application.
 * 
 * @author Spring Boot
 *
 */
@SpringBootApplication
public class KrowdBootApplication extends SpringBootServletInitializer {

	/**
	 * This method is used to convert the app packaging from .jar to .war.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KrowdBootApplication.class);
	}

	/**
	 * 
	 * The standard Java main method that starts the spring boot application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(KrowdBootApplication.class, args);
	}

}
