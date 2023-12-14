package com.feuji.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.employeeservice.dto.EmployeeDto;
import com.feuji.employeeservice.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveemployee")
	public ResponseEntity<Mono<EmployeeDto>> saveEmployeeDto(@RequestBody Mono<EmployeeDto> employeeDto) {

		return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
	}

	@PutMapping(value = "/updateemployee/{employeeId}")
	public ResponseEntity<Mono<EmployeeDto>> updateEmployee(@RequestBody Mono<EmployeeDto> employeeDto,
			@PathVariable(name = "employeeId") int employeeId) {
		return ResponseEntity.ok(employeeService.updateEmployee(employeeDto, employeeId));
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<Flux<EmployeeDto>> getAllEmployee() {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@GetMapping(value = "/getbyid/{id}")
	public ResponseEntity<Mono<EmployeeDto>> getEmployeeById(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@GetMapping(value = "/getemployeeinrange/{min}/{max}")
	public ResponseEntity<Flux<EmployeeDto>> getEmployeeInRange(@PathVariable(name = "min") double min,
			@PathVariable(name = "max") double max) {
		return ResponseEntity.ok(employeeService.getEmployeeInRange(min, max));
	}
}
