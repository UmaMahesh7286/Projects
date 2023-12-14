package com.example.iocmain;

public class School {

	private String name;
	private int noofstudents;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoofstudents() {
		return noofstudents;
		
	}
	public void setNoofstudents(int noofstudents) {
		this.noofstudents = noofstudents;
	}
	
	public void values() {
		System.out.println(name+"  "+noofstudents);
	}
	
	
}
