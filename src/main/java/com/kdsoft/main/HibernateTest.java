package com.kdsoft.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kdsoft.entities.HibernateUtil;
import com.kdsoft.entities.Student;
import com.kdsoft.entities.StudentDetails;

public class HibernateTest {

	public static void main(String[] args) {
		Student student1 = new Student("Kumar");
		Student student2 = new Student("Dharma");
		Student student3 = new Student("Loki");
		Student student4 = new Student("John");
		
		StudentDetails studentDetails1 = new StudentDetails("kumar@gmail.com", 81, student1);
		StudentDetails studentDetails2 = new StudentDetails("dharma@gmail.com", 74, student2);
		StudentDetails studentDetails3 = new StudentDetails("loki@gmail.com", 88, student3);
		StudentDetails studentDetails4 = new StudentDetails("john@gmail.com", 64, student4);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.save(studentDetails1);
		session.save(studentDetails2);
		session.save(studentDetails3);
		session.save(studentDetails4);
		session.beginTransaction().commit();
		session.close();
		
	}

}
