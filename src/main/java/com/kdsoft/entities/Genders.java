package com.kdsoft.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genders {
	
	@Id
	@GeneratedValue
	private Integer gender_id;
	private String gender;
	
	public Genders(String gender, HashSet<Employees> employees) {
		super();
		this.gender = gender;
		this.employees = employees;
	}
	public Genders() {
		super();
	}
	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	private Set<Employees> employees = new HashSet<>();
	
	public Set<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}
	public Integer getGender_id() {
		return gender_id;
	}
	public void setGender_id(Integer gender_id) {
		this.gender_id = gender_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
