package com.feuji.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.feuji.employeeservice.dto.EmployeeDto;
import com.feuji.employeeservice.repository.EmployeeRepository;
import com.feuji.employeeservice.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Flux<EmployeeDto> getEmployees() {
		return employeeRepository.findAll().map(AppUtils::entityToDto);
	}

	@Override
	public Mono<EmployeeDto> getEmployeeById(int id) {
		return employeeRepository.findById(id).map(AppUtils::entityToDto);
	}

	@Override
	public Flux<EmployeeDto> getEmployeeInRange(double min, double max) {

		return employeeRepository.findBySalaryBetween(Range.closed(min, max));
	}

	@Override
	public Mono<EmployeeDto> saveEmployee(Mono<EmployeeDto> employeeDtoMono) {
		return employeeDtoMono.map(AppUtils::dtoToEntity)
				.flatMap(employeeRepository::insert)
				.map(AppUtils::entityToDto);
	}

	@Override
	public Mono<EmployeeDto> updateEmployee(Mono<EmployeeDto> employeeDtoMono, int id) {
		return employeeRepository.findById(id)
				.flatMap(e->employeeDtoMono.map(AppUtils::dtoToEntity))
				.doOnNext(e->e.setEmployeeId(id))
				.flatMap(employeeRepository::save)
				.map(AppUtils::entityToDto);
	}

}
