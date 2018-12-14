package com.kdsoft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Student_Details")
public class StudentDetails {

	@Id
	@GeneratedValue(generator = "newGenerator")
	@GenericGenerator(name="newGenerator", strategy="foreign", parameters = {@Parameter(value="student", name="property")})
	private int id;
	private String email;
	private int marks;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Student student;

	public StudentDetails(String email, int marks, Student student) {
		super();
		this.email = email;
		this.marks = marks;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
