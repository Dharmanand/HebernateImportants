package com.kdsoft.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kdsoft.entities.Departments;
import com.kdsoft.entities.Employees;
import com.kdsoft.entities.Genders;
import com.kdsoft.entities.HibernateUtil;

public class EmployeesTest {

	public static void main(String[] args) {

		Genders genders1 = new Genders();
		genders1.setGender("Male");
		Genders genders2 = new Genders();
		genders2.setGender("Female");
		
		Departments departments1 = new Departments();
		Departments departments2 = new Departments();
		Departments departments3 = new Departments();
		departments1.setDepart_name("IT");
		departments2.setDepart_name("HR");
		departments3.setDepart_name("Finance");
		
		Employees employees1 = new Employees();
		employees1.setEmail("a@gmail.com");
		employees1.setEmp_name("AAA");
		employees1.setGender(genders1);
		employees1.setDepartment(departments1);
		
		Employees employees2 = new Employees();
		employees2.setEmail("b@gmail.com");
		employees2.setEmp_name("BBB");
		employees2.setGender(genders1);
		employees2.setDepartment(departments2);
		
		Employees employees3 = new Employees();
		employees3.setEmail("c@gmail.com");
		employees3.setEmp_name("CCC");
		employees3.setGender(genders2);
		employees3.setDepartment(departments3);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.save(employees1);
		session.save(employees2);
		session.save(employees3);
		session.beginTransaction().commit();
		session.close();
		
	}
	
	private static void insertEmployeesRecord(Employees Employees) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(Employees);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}

}
