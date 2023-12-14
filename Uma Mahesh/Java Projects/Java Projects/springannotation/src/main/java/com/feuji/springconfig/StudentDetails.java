package com.feuji.springconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentDetails {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student student = applicationContext.getBean(Student.class);
		System.out.println(student.getBranch());
		System.out.println(student.getMarks().getMarks());
		
		System.out.println("=============================================");
		
		DataBase dataBase = applicationContext.getBean(DataBase.class);
		System.out.println(dataBase.getUrl());
		System.out.println(dataBase.getUsername());
		System.out.println(dataBase.getPassword());
	}	
}
