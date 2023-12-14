package com.feuji.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.feuji.dto.User;

@Component
@Repository
@Transactional
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Serializable save(User user) {
		Session session = sessionFactory.getCurrentSession();

		Serializable serializable = session.save(user);
		System.out.println(serializable);

		return serializable;
	}

	@Transactional
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
	}

	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, id);
		session.delete(user);
		transaction.commit();
	}

	@Transactional
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM User", User.class);
		return query.getResultList();

	}

	public User findById(int id) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, id);
		return user;
	}
}
