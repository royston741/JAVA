/*
 Program : Create , read , update , delete method of BookDetail
 */

package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.BookDetail;
import com.util.HibernateUtil;

public class BookDetailDao {

	// save bookDetail
	public void saveBookDetail(BookDetail bookDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.save(bookDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// update bookDetail
	public void updateBookDetail(BookDetail bookDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.update(bookDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// get bookDetails
	public BookDetail getBookDetail(int id) {

		Transaction transaction = null;
		BookDetail book = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an book object
			book = session.get(BookDetail.class, id);
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
}
