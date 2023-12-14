package com.example.mvc.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.model.Student;

public interface Repository extends JpaRepository<Student, Integer> {

}
