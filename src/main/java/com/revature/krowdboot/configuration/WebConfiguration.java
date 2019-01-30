package com.revature.krowdboot.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Uncomment when CORS policy is needed
//@Configuration
//@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry corsReg) {

		corsReg.addMapping("/**")
				.allowedOrigins("http://localhost:4200", "http://krowd-blue.s3-website-eu-west-1.amazonaws.com",
						"http://krowd-green.s3-website-eu-west-1.amazonaws.com",
						"http://krowded.s3-website-eu-west-1.amazonaws.com")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");

	}

}
