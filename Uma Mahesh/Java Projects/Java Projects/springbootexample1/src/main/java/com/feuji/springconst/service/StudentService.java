package com.feuji.springconst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feuji.springconst.entity.Student;

@Service
public interface StudentService {
	
	public void insertStudent(Student student);
	public List<Student> getAll();
	public void updateStudent(Student student);
	public void deleteStudent(int id);
	public Optional<Student> getStudentById(int id);
}
