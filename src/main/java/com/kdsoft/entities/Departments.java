package com.kdsoft.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departments {
	
	@Id
	@GeneratedValue
	private Integer depart_id;
	private String depart_name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Employees> employees = new HashSet<>();
	
	public Departments(String depart_name, HashSet<Employees> employees) {
		super();
		this.depart_name = depart_name;
		this.employees = employees;
	}
	public Departments() {
		super();
	}
	public Set<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}
	public Integer getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(Integer depart_id) {
		this.depart_id = depart_id;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	
	

}
