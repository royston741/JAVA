/*
 Program : POJO class of Book
 */

package com.entity;

// imports
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	// book id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int id;

	// book name
	@Column(name = "book_name")
	private String bookName;

	// foreign key book_detail_id
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_detail_id")
	private BookDetail bookDetail;

	// no argument constructor
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}

	// getter and setter for bookId
	public int getBookId() {
		return id;
	}

	public void setBookId(int bookId) {
		this.id = bookId;
	}

	// getter and setter for bookName
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	// getter and setter for bookDetail
	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + id + ", bookName=" + bookName + ", bookDetailId=" + bookDetail + "]";
	}

}
