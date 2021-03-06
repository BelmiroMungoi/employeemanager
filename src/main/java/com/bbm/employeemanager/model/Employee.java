package com.bbm.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 70)
	@Column(nullable = false)
	private String name;
	
	@NotBlank
	@Email
	@Column(nullable = false)
	private String email;
	
	@NotBlank
	@Size(min = 2, max = 50)
	@Column(nullable = false)
	private String jobTitle;
	
	@NotBlank
	@Size(min = 9, max = 10)
	@Column(nullable = false)
	private String phone;
	private String image;
	
	@Column(nullable = false, updatable = false)
	private String employeCode;
	
	public Employee() {
	}
	
	public Employee(Long id, String name, String email, String jobTitle, String phone, String image,
			String employeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.image = image;
		this.employeCode = employeCode;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmployeCode() {
		return employeCode;
	}

	public void setEmployeCode(String employeCode) {
		this.employeCode = employeCode;
	}

}
