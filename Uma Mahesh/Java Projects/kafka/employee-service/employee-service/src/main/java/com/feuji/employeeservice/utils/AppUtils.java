package com.feuji.employeeservice.utils;

import org.springframework.beans.BeanUtils;

import com.feuji.employeeservice.dto.EmployeeDto;
import com.feuji.employeeservice.entity.Employee;

public class AppUtils {

	public static EmployeeDto entityToDto(Employee employee) {
		EmployeeDto dto=new EmployeeDto();
		BeanUtils.copyProperties(employee, dto);
		return dto;
	}
	
	
	public static Employee dtoToEntity(EmployeeDto dto) {
		Employee employee=new Employee();
		BeanUtils.copyProperties(dto, employee);
		return employee;
	}
}
