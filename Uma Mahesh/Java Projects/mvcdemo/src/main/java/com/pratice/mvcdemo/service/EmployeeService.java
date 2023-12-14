package com.pratice.mvcdemo.service;

import java.util.List;

import com.pratice.mvcdemo.entity.Employee;

public interface EmployeeService {

	public void insertEmp(Employee employee);

	public List<Employee> fetchData();

	public void deleteEmployee(int numberbean);

	public Employee updateEmployee(int id);
}
