package com.feuji.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import jakarta.annotation.PostConstruct;

@ComponentScan(basePackages = "com.feuji.springconfig")
@Configuration
public class StudentConfig {
	
	@Bean(initMethod = "init")
	public Student getStudent() {
		return new Student(1,"ram","Mech");
	}
	
	@Bean
	public Marks getMarks() {
		return new Marks(900,90.0);
	}
	
}
