/*
 Program : Create , read , update , delete method of Book
 */

package com.dao;

// imports
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Book;
import com.util.HibernateUtil;

public class BookDao {

	/**
	 * Save Book
	 */
	public void saveBook(Book book) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.save(book);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Book
	 */
	public void updateBook(Book book) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.update(book);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete book
	 */
	public void deleteBook(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a book object
			Book book = session.get(Book.class, id);
			if (book != null) {
				session.delete(book);
				System.out.println("Book is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get book By ID
	 */
	public Book getBook(int id) {

		Transaction transaction = null;
		Book book = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an book object
			book = session.get(Book.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return book;
	}

	/**
	 * Get all Book
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {

		Transaction transaction = null;
		List<Book> listOfBook = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an book object

			listOfBook = session.createQuery("from Book").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfBook;
	}

}
