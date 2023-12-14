package com.pratice.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.mvcproject.entity.Employee;
import com.pratice.mvcproject.repository.EmployeeRepo;

@Service
public class Employeeserviceimplementation implements Employeeservice{
	
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public String insertemp(Employee employee) {
		return employeeRepo.insertemp(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.getAllEmployee();
	}

	@Override
	public String deleteEmployee(int id) {
		return employeeRepo.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(int id) {
		return employeeRepo.updateEmployee(id);
	}

}
