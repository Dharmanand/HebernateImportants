package com.kdsoft.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kdsoft.entities.HibernateUtil;
import com.kdsoft.entities.Student;

public class HibernateTest {

	public static void main(String[] args) {
		Student student = new Student("Kumar", "kumar@gmail.com", 81);
		student.setId(101);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.save(student);
		session.beginTransaction().commit();
		
	}

}
