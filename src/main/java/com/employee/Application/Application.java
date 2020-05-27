package com.employee.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages ="com.employee.Application")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
