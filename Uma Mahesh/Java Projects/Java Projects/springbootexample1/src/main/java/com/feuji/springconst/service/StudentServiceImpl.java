package com.feuji.springconst.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.springconst.entity.Student;
import com.feuji.springconst.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void insertStudent(Student student) {
		student = studentRepository.save(student);
		student.getStudentId();
	}

	@Override
	public List<Student> getAll() {
		 List<Student> list = studentRepository.findAll();
		return list;
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
		student.getStudentId();
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
		
	}
	
	public Optional<Student> getStudentById(int id) {
		 Optional<Student> student= studentRepository.findById(id);
		 return student;
	}
	
	
	
	
}
