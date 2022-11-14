package com.libraryManagement.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Library.class);

		// Create Session Factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Initialize Session Object
		Session session = sessionFactory.openSession();

		Library book1 = new Library();

		book1.setBookId(1);
		book1.setBookName("Harry Potter");
		book1.setBookAuthorName("Royston Rodrigues");

		session.beginTransaction();
		// Here we have used
		// save() method of JPA
		session.save(book1);

		session.getTransaction().commit();
	}
}
