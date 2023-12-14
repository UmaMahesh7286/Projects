package com.example.ioc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MoblieConfig.class);
//		 BeanFactory context=new AnnotationConfigApplicationContext(MoblieConfig.class);
		Lenovo leno = context.getBean("getvalues", Lenovo.class);
		leno.values();

	}

}

//
/// spring bean container
//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MoblieConfig.class);
//
//Mobiles obj=context.getBean("getlenovomodel",Mobiles.class);
//obj.getmodel();
//
//Mobiles obj1=context.getBean("getiphonemodel",Mobiles.class);
//obj1.getmodel();