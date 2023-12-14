package com.feuji.Finalmvc.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feuji.Finalmvc.entity.Employee;

@Repository  
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionfactory;

	public void insertEmp(Employee employee) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	public List<Employee> fetchData() {
		Session session = sessionfactory.getCurrentSession();
		NativeQuery<Employee> nativeQuery = session.createNativeQuery("select * from employee_mvc", Employee.class);
		return nativeQuery.getResultList();
	}

	public void deleteEmployee(int id) {
		Session session = sessionfactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		session.delete(employee);
	}

	public Employee updateEmployee(int id) {

		Session session = sessionfactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		return employee;

	}
}
