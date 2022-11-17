/*
 Program : POJO class of BookDetail
 */

package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_detail")
public class BookDetail {

	// bookDetail id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// book type
	@Column(name = "book_type")
	private String bookType;

	// book author name
	@Column(name = "book_author_name")
	private String bookAuthorName;

	// book price
	@Column(name = "book_price")
	private int bookPrice;

	@ManyToMany(mappedBy = "bookDetail", cascade = CascadeType.ALL)
	private Book book;

	// no argument constructor
	public BookDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public BookDetail(String bookType, String bookAuthorName, int bookPrice) {
		super();
		this.bookType = bookType;
		this.bookAuthorName = bookAuthorName;
		this.bookPrice = bookPrice;
	}

	// getter and setter for id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// getter and setter for bookType
	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	// getter and setter for bookAuthorName
	public String getBookAuthorName() {
		return bookAuthorName;
	}

	public void setBookAuthorName(String bookAuthorName) {
		this.bookAuthorName = bookAuthorName;
	}

	// getter and setter for bookPrice
	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	// getter and setter for Book
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookDetail [id=" + id + ", bookType=" + bookType + ", bookAuthorName=" + bookAuthorName + ", bookPrice="
				+ bookPrice + ", book=" + book + "]";
	}

}
