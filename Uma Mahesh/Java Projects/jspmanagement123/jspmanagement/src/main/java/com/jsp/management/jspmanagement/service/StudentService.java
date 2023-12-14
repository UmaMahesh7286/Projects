package com.jsp.management.jspmanagement.service;

import java.util.List;

import com.jsp.management.jspmanagement.entity.Student;

public interface StudentService {

	
    public void insert(Student student);
	
	public void delete(int id);
	
	public Student update(int id);
	
	public List<Student> getAllStudent();
	
}
