package com.feuji.employeeservice.service;

import com.feuji.employeeservice.dto.EmployeeDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

	public Flux<EmployeeDto> getEmployees();

	public Mono<EmployeeDto> getEmployeeById(int id);

	public Flux<EmployeeDto> getEmployeeInRange(double min, double max);

	public Mono<EmployeeDto> saveEmployee(Mono<EmployeeDto> employeeDtoMono);

	public Mono<EmployeeDto> updateEmployee(Mono<EmployeeDto> employeeDtoMono, int id);

}
