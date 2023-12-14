package com.feuji.Finalmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feuji.Finalmvc.entity.Employee;
import com.feuji.Finalmvc.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/insert")
	public ModelAndView insert() {
		return new ModelAndView("insert", "employee", new Employee());
	}

	@PostMapping(value = "/showDetails")
	public String notify(Employee employee, ModelMap modelMap) {
		modelMap.put("employee", employee);
		employeeService.insertEmp(employee);
		return "redirect:/datatable";
	}

	@GetMapping(value = "/datatable")
	public ModelAndView getAllEmployees() {
		List<Employee> employeeList = employeeService.fetchData();
		return new ModelAndView("employeeData", "employees", employeeList);
	}

	@GetMapping(value = "/delete")
	public String deleteEmployee(@RequestParam("empId") int id) {
		log.info("id no:", id);
		employeeService.deleteEmployee(id);
		log.info("deleted");
		return "redirect:/datatable";
	}

	@GetMapping(value = "/insertupdate")
	public ModelAndView updateEmployee(@RequestParam("empId") int id) {
		Employee emp = employeeService.updateEmployee(id);
		log.info("get by id", emp);
		System.out.println(emp);
		return new ModelAndView("insert", "employee", emp);
	}
}
