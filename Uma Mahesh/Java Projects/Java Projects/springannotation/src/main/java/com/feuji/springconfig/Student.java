package com.feuji.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Component
public class Student {

	private int id;
	private String name;
	private String branch;
	private Marks marks;

	public Student() {
		
	}

	public Student(int id, String name, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Marks getMarks() {
		return marks;
	}
	@Autowired
	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	
	public void init() {
		System.out.println("From init method in Student class");
	}

}
