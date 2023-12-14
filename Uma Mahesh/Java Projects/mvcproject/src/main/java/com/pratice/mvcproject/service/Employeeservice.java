package com.pratice.mvcproject.service;

import java.util.List;

import com.pratice.mvcproject.entity.Employee;

public interface Employeeservice {
	
	public String insertemp(Employee employee);
	public List<Employee> getAllEmployee();
	public String deleteEmployee(int id);
	public Employee updateEmployee(int id);
	
}
