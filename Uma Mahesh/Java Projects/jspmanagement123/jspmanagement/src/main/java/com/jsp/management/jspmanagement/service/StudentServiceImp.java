package com.jsp.management.jspmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.management.jspmanagement.entity.Student;
import com.jsp.management.jspmanagement.repository.StudentRepo;
@Service
@Transactional
public class StudentServiceImp implements StudentService  {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		studentRepo.insert(student);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		studentRepo.delete(id);
		
	}

	@Override
	public Student update(int id) {
		// TODO Auto-generated method stub
		return studentRepo.update(id);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepo.getAllStudent();
	}

}
