package com.feuji.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.feuji.dto.StudentMarks;

@Repository
public class StudentMarksRepository implements StudentMarksDao {
	
	public SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveStudentMarks(StudentMarks marks) {
		Session session = sessionFactory.getCurrentSession();
		session.save(marks);
	}

}
