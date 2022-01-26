package com.bbm.employeemanager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbm.employeemanager.model.Employee;
import com.bbm.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
}
