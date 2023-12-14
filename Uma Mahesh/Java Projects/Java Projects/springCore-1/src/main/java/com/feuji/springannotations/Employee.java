package com.feuji.springannotations;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Component;
@Component
public class Employee {

	private int id;
	private String name;
	private String designation;
	private Address address;
	private Department department;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String designation, Address address,Department department) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.address = address;
		this.department = department;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	@Autowired
	@Qualifier(value = "address")
	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}
	@Autowired
	@Qualifier(value = "department1")
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", address=" + address
				+ ", department=" + department + "]";
	}

	

}
