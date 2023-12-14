package com.pratice.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pratice.mvcproject.entity.Employee;
import com.pratice.mvcproject.service.Employeeservice;

@Controller
public class EmployeeController {

	@Autowired
	Employeeservice employeeservice;

	@GetMapping(value = "/insert")
	public ModelAndView insertEmployee() {
		return new ModelAndView("insert", "employee", new Employee());
	}
	
	@PostMapping(value = "/showDetails")
	public String notify(Employee employee,ModelMap map) {
		map.put("employee", employee);
		employeeservice.insertemp(employee);
		return "redirect:/datatable";
	}
	
	@GetMapping(value = "/datatable")
	public ModelAndView getAllEmployees() {
		List<Employee> employeesList=employeeservice.getAllEmployee();
		return new ModelAndView("employeedata","employees",employeesList);
	}
}
