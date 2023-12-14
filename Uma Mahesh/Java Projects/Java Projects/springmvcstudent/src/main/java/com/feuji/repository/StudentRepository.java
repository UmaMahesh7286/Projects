package com.feuji.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feuji.dto.Student;
import com.feuji.dto.StudentMarks;

@Repository
public class StudentRepository implements StudentDao {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		
	}

}
