package com.feuji.repository;

import org.springframework.stereotype.Repository;

import com.feuji.dto.StudentMarks;

@Repository
public interface StudentMarksDao {
	public void saveStudentMarks(StudentMarks marks);
}
