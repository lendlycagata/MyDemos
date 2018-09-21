package com.careercitydashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication

@ComponentScan(basePackages= {"com.careercitydashboard"})
public class CareerCityDashboardApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CareerCityDashboardApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CareerCityDashboardApplication.class, args);
	}
}
