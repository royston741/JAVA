package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

public class StudentDao {
	// Create
	// Save student method
	public void saveStudent(Student student) {
		// no transaction has been started
		Transaction transaction = null;
		// creating a session for e.g visiting a ATM is a session and there we will be
		// performing transactions
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.save(student);

			// commit the transaction
			transaction.commit();
			System.out.println("Student saved");
		}
		// if any exception
		catch (Exception e) {
			if (transaction != null) {
				// undo work done in the correct transaction
				transaction.rollback();
			}
		}
	}

	// Read
	// Get single student method
	public Student getStudentById(long id) {
		// no transaction has been started
		Transaction transaction = null;
		// declare a student object to store the student that we will get by using the
		// id
		Student student = null;
		// creating a session for e.g visiting a ATM is a session and there we will be
		// performing transactions
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// getting student by id and storing student
			student = session.get(Student.class, id);

			// commit the transaction
			transaction.commit();
		}
		// if any exception
		catch (Exception e) {
			if (transaction != null) {
				// undo work done in the correct transaction
				transaction.rollback();
			}
		}

		return student;
	}

	// Get all student method
	public List<Student> getAllStudent() {
		// no transaction has been started
		Transaction transaction = null;
		// list of students is empty
		List<Student> students = null;
		// creating a session for e.g visiting a ATM is a session and there we will be
		// performing transactions
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// getting all students
			students = session.createQuery("from Student").list();

			// commit the transaction
			transaction.commit();
		}
		// if any exception
		catch (Exception e) {
			if (transaction != null) {
				// undo work done in the correct transaction
				transaction.rollback();
			}
		}

		return students;
	}

	// Update
	// Update student method
	public void updateStudent(Student student) {
		// no transaction has been started
		Transaction transaction = null;
		// creating a session for e.g visiting a ATM is a session and there we will be
		// performing transactions
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save or update student object
			session.saveOrUpdate(student);

			// commit the transaction
			transaction.commit();
			System.out.println("Student updated");
		}
		// if any exception
		catch (Exception e) {
			if (transaction != null) {
				// undo work done in the correct transaction
				transaction.rollback();
			}
		}
	}

	// Delete
	// Delete a student method
	public Student deleteStudent(long id) {
		// no transaction has been started
		Transaction transaction = null;
		// declare a student object to store the student that we will get by using the
		// id
		Student student = null;
		// creating a session for e.g visiting a ATM is a session and there we will be
		// performing transactions
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// getting student by id and storing student
			student = session.get(Student.class, id);
//			System.out.println(student.getStdId());

			// delete that student
			session.delete(student);

			// getting the student after deletion
			student = getStudentById(id);

			// commit the transaction
			transaction.commit();

			System.out.println("Student delete");
		}
		// if any exception
		catch (Exception e) {
			if (transaction != null) {
				// undo work done in the correct transaction
				transaction.rollback();
			}

		}

		return student;
	}

}
