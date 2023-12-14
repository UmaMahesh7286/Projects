package com.feuji.springconst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.feuji.springconst.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
