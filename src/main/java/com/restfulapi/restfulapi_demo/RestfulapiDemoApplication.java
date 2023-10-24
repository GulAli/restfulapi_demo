package com.restfulapi.restfulapi_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RestfulapiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulapiDemoApplication.class, args);
	}

}