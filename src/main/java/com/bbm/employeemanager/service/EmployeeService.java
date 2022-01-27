package com.bbm.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbm.employeemanager.exception.UserNotFoundException;
import com.bbm.employeemanager.model.Employee;
import com.bbm.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		Employee employeeExists = employeeRepository.findByEmail(employee.getEmail());
		
		if (employeeExists != null && !employeeExists.equals(employee)) {
			throw new RuntimeException("Employee Already Exists With That Email Adress");
		}
		employee.setEmployeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Usuário com o ID " + id + " não foi encontrado!"));
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
