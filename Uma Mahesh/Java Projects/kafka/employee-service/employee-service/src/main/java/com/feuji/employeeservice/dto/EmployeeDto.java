package com.feuji.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int employeeId;
	private String employeeName;
	private String email;
	private String password;
	private String phoneNumber;
	private double salary;
}
