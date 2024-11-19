package com.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
//@ComponentScan(basePackages = "com.portal.service")
//@ComponentScan({"com.portal.service","com.portal.controller","com.portal.entity"})

public class OnlineTutorPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTutorPortalApplication.class, args);
	}

}
