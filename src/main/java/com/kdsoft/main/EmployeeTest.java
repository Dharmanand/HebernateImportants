package com.kdsoft.main;

import org.hibernate.Session;

import com.kdsoft.entities.Employee;
import com.kdsoft.entities.HibernateUtil;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee emp1 = new Employee("kd@gmail.com", "Kumar");
		Employee emp2 = new Employee("dd@gmail.com", "Dharma");
//		insertEmployeeRecord(emp1);
//		insertEmployeeRecord(emp2);
		
		
//	Dirty check in hibernate with same employee record with different objects	
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Employee emp = (Employee) session1.get(Employee.class, 1);
		session1.getTransaction().commit();
		emp.setName("KD2");//emp detached here
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		Employee emp3 = (Employee) session2.get(Employee.class, 1);
//		session2.update(emp);// org.hibernate.NonUniqueObjectException Occurs,  because objects emp and emp3 have same id=1.
		session2.merge(emp);//It will updated the record with id=1, correctly without fail.
		session2.getTransaction().commit();
		
		
	}
	
	private static void insertEmployeeRecord(Employee employee) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}

}
