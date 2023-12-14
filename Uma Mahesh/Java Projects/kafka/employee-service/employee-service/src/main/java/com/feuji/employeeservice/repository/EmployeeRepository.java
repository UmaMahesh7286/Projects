package com.feuji.employeeservice.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.feuji.employeeservice.dto.EmployeeDto;
import com.feuji.employeeservice.entity.Employee;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

	@Query()
	Flux<EmployeeDto> findBySalaryBetween(Range<Double> closed);

}
