package com.jsp.management.jspmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.management.jspmanagement.entity.Student;
import com.jsp.management.jspmanagement.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/insert")
	public ModelAndView test()
	{
		return new ModelAndView("insert","student",new Student());
	}
	
	@PostMapping("/studentdetails")
	public String details(Student student,ModelMap modelMap)
	{
		modelMap.put("student", student);
		studentService.insert(student);
		return "redirect:/displayall";
		
	}
	
	@GetMapping("/displayall")
	public ModelAndView fetchAll(ModelMap map) {
		List<Student> list=studentService.getAllStudent();
		long count= list.stream().count();
		map.put("count", count);
		return new ModelAndView("view","student",list);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("stuId") int id )
	{
		studentService.delete(id);
		return "redirect:/displayall";	
	}


	@GetMapping("/insertupdate")
	public ModelAndView updateemp(@RequestParam("stuId") int id) {
		System.out.println("entering");
		Student student=studentService.update(id);
		return new ModelAndView("insert","student",student);
	}
}
