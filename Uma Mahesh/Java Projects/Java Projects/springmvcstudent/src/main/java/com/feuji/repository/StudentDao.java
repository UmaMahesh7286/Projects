package com.feuji.repository;

import org.springframework.stereotype.Repository;

import com.feuji.dto.Student;

@Repository
public interface StudentDao {
	public void saveStudent(Student student);
}
