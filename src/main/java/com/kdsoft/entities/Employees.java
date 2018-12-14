package com.kdsoft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employees {

	@Id
	@GeneratedValue
	private Integer emp_id;

	private String email;

	private String emp_name;

	@ManyToOne(cascade = CascadeType.ALL)
	private Genders gender;

	@ManyToOne(cascade = CascadeType.ALL)
	private Departments department;

	public Employees() {
		super();
	}

	public Employees(String email, String emp_name, Genders gender, Departments department) {
		super();
		this.email = email;
		this.emp_name = emp_name;
		this.gender = gender;
		this.department = department;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
