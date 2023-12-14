package com.feuji.springmvcstudent.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuji.dto.Student;
import com.feuji.dto.StudentMarks;
import com.feuji.repository.StudentMarksRepository;
import com.feuji.repository.StudentRepository;
import com.feuji.springmvcstudent.config.DBConfiguration;



public class StudentController {
	
	 public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfiguration.class);
		StudentRepository repository = applicationContext.getBean(StudentRepository.class);
		StudentMarksRepository repository2 = applicationContext.getBean(StudentMarksRepository.class);
		//StudentDao studentDao = repository;
		Student student = new Student();
		student.setStudentName("sai");
		student.setStudentAge(22);
		student.setStudentPhno(8977647658l);
		repository.saveStudent(student);
		
		//StudentMarksDao dao = repository2;
		StudentMarks marks = new StudentMarks();
		marks.setMaths(90);
		marks.setTelugu(89);
		marks.setEnglish(95);
		marks.setTotalMarks(marks.getMaths()+marks.getTelugu()+marks.getEnglish());
		marks.setStudent(student);
		repository2.saveStudentMarks(marks);
	}

}
