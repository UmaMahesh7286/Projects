package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.model.Student;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	Repository repository;
	
	@GetMapping(value="/")
	public String gethome() {
		return "home.jsp";
	}
	
	@PostMapping(value="/addstudent")
	public String addstu(Student student, Model model) {
		repository.save(student);
		model.addAttribute("student", repository.findAll());
		return "result.jsp";
	}
}
