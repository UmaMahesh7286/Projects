package com.feuji.springannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DetailsOfEmployee {
	
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springannotation.xml");
		  Employee employee= applicationContext.getBean("employee",Employee.class);
		  System.out.println(employee.getName());
		  System.out.println(employee.getAddress().getState());
		  System.out.println(employee.getDepartment().getDepartmentName());
		  
		  System.out.println("========================================================");
		  
		 Employee employee2 = applicationContext.getBean("employee1",Employee.class);
		 System.out.println(employee2.getName());
		 System.out.println(employee2.getAddress().getCity());
		 System.out.println(employee2.getDepartment().getId());
		 
		 System.out.println("------------------------------------------------------");
		 DBInfo dbInfo = applicationContext.getBean(DBInfo.class);
		 System.out.println(dbInfo.getUrl());
	}

}
