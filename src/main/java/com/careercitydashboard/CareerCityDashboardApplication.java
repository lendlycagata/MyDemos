package com.careercitydashboard;

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
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
	@Bean
	public TomcatServletWebServerFactory tomcatCustomizer() {
	  TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	  factory.addConnectorCustomizers((connector -> {
	    connector.addUpgradeProtocol(new Http2Protocol());
	  }));
	  return factory;
	}
}
