package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.core.net.SyslogOutputStream;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
    	System.out.println("Welcome to the Vaccination Application");
    	Scanner scn = new Scanner(System.in);
    	System.out.println("Please choose your vaccine preference");
    	String[] diseases = {"1.Covid","2.Polio","3.Typhoid"};
    	for(int i = 0;i<diseases.length; i++) {
    		System.out.println(diseases[i]);
    	}
    	
    	int vaccineType = scn.nextInt();
    	System.out.println("Whom do you want to vaccinate");
    	switch(vaccineType) {
    	case 1 :{
    		String[] familyMembers = {"1.Father","2.Mother","3.Self","4.Spouse","5.Exit"};
    		for(int i = 0;i<familyMembers.length; i++) {
        		System.out.println(familyMembers[i]);
        	}
    		int relationType = scn.nextInt();
    		switch(relationType) {
    		case 1 :{
    			String relationName = familyMembers[relationType-1].substring(2);
    			System.out.println("Please enter "+relationName+" details");
    			Scanner relation = new Scanner(System.in);
    			System.out.print("Name: ");
    			String takeRelationName = relation.nextLine();
    			System.out.print("Age: ");
    			int takeRelationAge =  relation.nextInt();
    			System.out.print("Appointment date (YYYY-MM-DD): ");
    			String takeAppointmentDate = relation.nextLine();
    			System.out.print("Appointment time (HH:MM AM/PM): ");
    			String takeAppointmentTime = relation.nextLine();
    			System.out.print("Appointment location:");
    			String takeAppointmentLocation = relation.nextLine();
    			Father father = (Father) context.getBean("father");
    			father.timeAndLocation.date = takeAppointmentDate;
    			father.timeAndLocation.timeSlot = takeAppointmentTime;
    			father.timeAndLocation.location = takeAppointmentLocation;
    			father.setUserDetails(takeRelationName, takeRelationAge, father.timeAndLocation);
				//father.timeAndLocation.setDetails(takeAppointmentTime, takeAppointmentLocation, takeAppointmentDate);
			//	father.setAppointment();
    			
    			

    			
    		}
    		}
    	}
    	}

    }
}