/*
 Program : library management system
 @Author : Royston
 @Date : 16 Nov
 */

package com.librarymanagement.librarymanagementsystem;

import java.util.List;

import com.dao.BookDao;
import com.entity.Book;
import com.entity.BookDetail;

public class App {
	public static void main(String[] args) {

		// creating book object
		Book book = new Book("Harry potter");
		// creating bookDetail object
		BookDetail bookDetail = new BookDetail("Adventure", "Royston", 100);
		// set the book object
		bookDetail.setBook(book);
		// set the bookDetail object
		book.setBookDetail(bookDetail);

		// creating book1 object
		Book book1 = new Book("Sandman");
		// creating bookDetail1 object
		BookDetail bookDetail1 = new BookDetail("Mystery", "Raju", 200);
		// set the book object
		bookDetail1.setBook(book1);
		// set the bookDetail object
		book1.setBookDetail(bookDetail1);

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
