package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create SessionFactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session

		Session session = factory.getCurrentSession();

		// use the session object to save the java object

		try {
			// create the objects

			// associate the objects

			// start a transaction
			session.beginTransaction();

			// get the instructor by primary key id

			int theId = 2;
			Instructor theInstructor = session.get(Instructor.class, theId);

			System.out.println("Found Instrctor : " + theInstructor);

			// delete the instructor

			if (theInstructor != null) {
				System.out.println("Deleting the Instrctor: " + theInstructor);

				// this will also delete the InstructorDetail object because of casecadeType=ALL
				session.delete(theInstructor);
			} 

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
