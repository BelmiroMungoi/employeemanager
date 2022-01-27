package com.bbm.employeemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbm.employeemanager.model.Employee;
import com.bbm.employeemanager.repository.EmployeeRepository;
import com.bbm.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(value = "/")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee saveEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> employees = employeeService.findAllEmployee();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(employeeService.findEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/")
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee employee) {

		if (employee.getId() == null) {
			return new ResponseEntity<String>("Employee Not Found", HttpStatus.NOT_FOUND);
		}

		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		
		if (!employeeRepository.existsById(id)) {
			return new ResponseEntity<String>("Employee Not Found Or Was Already Deleted", HttpStatus.NOT_FOUND);
		}
		
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("User Deleted With Success", HttpStatus.OK);
	}
}
