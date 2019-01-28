package com.revature.krowdboot.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import static com.google.common.base.Predicates.*;
import com.google.common.base.Predicate;

import static springfox.documentation.builders.PathSelectors.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

	@Bean
	public Docket krowdRestApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.revature.krowdboot.controller")).paths(paths()).build()
				.apiInfo(metadata());

	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Krowd v2 Rest API").version("2.0")
				.description("Spring Boot RESTful API for Krowd v2 - Online Social Platform").license("MIT License")
				.licenseUrl("https://opensource.org/licenses/MIT").build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

	private Predicate<String> paths() {

		List<Predicate<String>> regexList = new ArrayList<>();

		regexList.add(regex("/admin.*"));
		regexList.add(regex("/user.*"));
		regexList.add(regex("/event.*"));
		regexList.add(regex("/comment.*"));
		regexList.add(regex("/userEvent.*"));

		return or(regexList);

	}

}
