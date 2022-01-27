package com.bbm.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbm.employeemanager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByEmail(String email);

}
