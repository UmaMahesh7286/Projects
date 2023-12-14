package com.example.iocmain;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationCon {

	public static void main(String[] args) {

//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SchoolConfig.class);
//		ApplicationContext context = new AnnotationConfigApplicationContext(SchoolConfig.class);
		BeanFactory context = new AnnotationConfigApplicationContext(SchoolConfig.class);
		School school = context.getBean(School.class);
		school.values();
	}
}