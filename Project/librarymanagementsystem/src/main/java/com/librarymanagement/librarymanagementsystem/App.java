/*
 Program : library management system many to many
 @Author : Royston
 @Date : 17 Nov
 */

package com.librarymanagement.librarymanagementsystem;

import java.util.List;

import com.dao.BookDao;
import com.entity.AuthorDetail;
import com.entity.Book;
import com.entity.BookDetail;

public class App {
	public static void main(String[] args) {

		// creating book object
		Book book = new Book("Harry potter");
		// creating bookDetail object
		BookDetail bookDetail = new BookDetail("Adventure", "Royston", 100);
		// creating AuthorDetail object
		AuthorDetail authorDetail = new AuthorDetail("Royston", "Rodrigues", 20);
		// set the book object
		bookDetail.setBook(book);
		// set the bookDetail object
		book.setBookDetail(bookDetail);
		// set AuthorDetail object
		authorDetail.setAuthor(authorDetail);

		// creating book1 object
		Book book1 = new Book("Sandman");
		// creating bookDetail1 object
		BookDetail bookDetail1 = new BookDetail("Mystery", "Raju", 200);
		// creating AuthorDetail object
		AuthorDetail authorDetail1 = new AuthorDetail("Raju", "Raju", 20);
		// set the book object
		bookDetail1.setBook(book1);
		// set the bookDetail object
		book1.setBookDetail(bookDetail1);
		// set AuthorDetail object
		authorDetail.setAuthor(authorDetail1);

		// Create bookDao object
		BookDao bookDao = new BookDao();
		// add book1 to table
		bookDao.saveBook(book);
		// add book1 to table
		bookDao.saveBook(book1);

		// Get all books
		List<Book> books = bookDao.getAllBook();
		// print all books name using lambda
		books.forEach(b -> System.out.println(b.getBookName()));
	}
}
