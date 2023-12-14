package com.pratice.mvcproject.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import com.pratice.mvcproject.entity.Employee;

public class Employeerepoimplemantation implements EmployeeRepo{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public String insertemp(Employee employee) {
		Session session= factory.getCurrentSession();
		session.save(employee);
		return "Employee added Succesfully";
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session=factory.getCurrentSession();
		Query<Employee> query=session.createNamedQuery("select * from employee", Employee.class);
		 return query.getResultList();
	}

	@Override
	public String deleteEmployee(int id) {
		Session session=factory.getCurrentSession();
		Employee employee=session.get(Employee.class, id);
		session.delete(employee);
		return "Employee removed Successfully"+id;
	}

	@Override
	public Employee updateEmployee(int id) {
		Session session=factory.getCurrentSession();
		Employee employee=session.get(Employee.class, id);
		return employee;
	}

}
