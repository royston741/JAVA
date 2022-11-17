package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.AuthorDetail;
import com.util.HibernateUtil;

public class AuthorDetailDao {

	// save authorDetail
	public void saveAuthorDetail(AuthorDetail authorDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.save(authorDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// update authorDetail
	public void updateAuthorDetail(AuthorDetail authorDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.update(authorDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// get authorDetails
	public AuthorDetail getAuthorDetail(int id) {

		Transaction transaction = null;
		AuthorDetail author = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get author object
			author = session.get(AuthorDetail.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return author;

	}
}