package com.jsp.management.jspmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
   
	@Id
	private int id;
	private String name;
	private String graduation;
	private String stream;
	private String email;
	private long phone;
	private int yop;
	private String course;
	
	
	
	//construcotr with feilds
	public Student(int id, String name, String graduation, String stream, String email, long phone, int yop,
			String course) {
		super();
		this.id = id;
		this.name = name;
		this.graduation = graduation;
		this.stream = stream;
		this.email = email;
		this.phone = phone;
		this.yop = yop;
		this.course = course;
	}
	
	//supercall
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	//setters and getters
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
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", graduation=" + graduation + ", stream=" + stream + ", email="
				+ email + ", phone=" + phone + ", yop=" + yop + ", course=" + course + "]";
	} 
	
	
	
	
	
}
