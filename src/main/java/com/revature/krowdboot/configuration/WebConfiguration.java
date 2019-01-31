package com.revature.krowdboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * The class that configures the CORS policy for the application.
 * 
 * @author Eddy Soma
 *
 */
// Uncomment when CORS policy is needed
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

	/**
	 * 
	 * The method that registers the allowed CORS origins and HTTP methods.
	 */
	@Override
	public void addCorsMappings(CorsRegistry corsReg) {

		corsReg.addMapping("/**")
				.allowedOrigins("http://localhost:4200", "http://krowd-blue.s3-website-eu-west-1.amazonaws.com",
						"http://krowd-green.s3-website-eu-west-1.amazonaws.com",
						"http://krowded.s3-website-eu-west-1.amazonaws.com")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");

	}

}
