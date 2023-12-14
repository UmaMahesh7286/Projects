package com.jsp.management.jspmanagement.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.management.jspmanagement.entity.Student;


@Repository
public class StudentRepoImp implements StudentRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Student student=session.get(Student.class,id);
		session.delete(student);
		
	}

	@Override
	public Student update(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Student student=session.get(Student.class,id);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		Session session=sessionFactory.getCurrentSession();
		NativeQuery<Student> nativeQuery=session.createNativeQuery("select * from student", Student.class);
		return nativeQuery.getResultList();
	}

}
