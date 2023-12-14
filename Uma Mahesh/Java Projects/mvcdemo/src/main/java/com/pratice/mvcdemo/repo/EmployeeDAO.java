package com.pratice.mvcdemo.repo;

import java.util.List;

import com.pratice.mvcdemo.entity.Employee;

public interface EmployeeDAO {

	public void insertEmp(Employee employee);

	public List<Employee> fetchData();

	public void deleteEmployee(int numberbean);

	public Employee updateEmployee(int id);

}