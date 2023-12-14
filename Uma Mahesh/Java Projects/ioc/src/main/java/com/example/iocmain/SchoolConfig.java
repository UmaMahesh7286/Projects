package com.example.iocmain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {

	@Bean
	public School getvalues() {
		School school=new School();
		school.setName("maha"); // setter injection
		school.setNoofstudents(10);
		return school;
	}
}
