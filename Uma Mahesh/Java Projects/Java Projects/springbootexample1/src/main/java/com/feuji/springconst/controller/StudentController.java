package com.feuji.springconst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.springconst.entity.Student;
import com.feuji.springconst.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired(required = true)
	private StudentService studentService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/save")
	public Student saveStudent(@RequestBody Student student) {
		 studentService.insertStudent(student);
//		String body = "created student with id : "+ id;
//		return ResponseEntity.ok(body);
		return student;
	}
	
	@GetMapping("/displayAll")
	public ResponseEntity<List<Student>> display() {
		System.out.println("from display");
		List<Student> list = studentService.getAll();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		studentService.deleteStudent(id);
//		String res = "Student deleted Sucessfully";
//		return ResponseEntity.ok(res);
	}
	
	@GetMapping(value="/getById/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable(value ="id") int id) {
		 Optional<Student> optional = studentService.getStudentById(id);
		 return ResponseEntity.ok(optional);
	}
	
	@PutMapping(value = "/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return student;
	}
	
	
	

}
