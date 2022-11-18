package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "author_detail")
public class AuthorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// author first name
	@Column(name = "author_first_name")
	private String authorFirstName;

	// author second name
	@Column(name = "author_second_name")
	private String authorSecondName;

	// book price
	@Column(name = "author_age")
	private int authorAge;

	@OneToOne(mappedBy = "bookDetail", cascade = CascadeType.ALL)
	private AuthorDetail author;

	public AuthorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorDetail(String authorFirstName, String authorSecondName, int authorAge) {
		super();
		this.authorFirstName = authorFirstName;
		this.authorSecondName = authorSecondName;
		this.authorAge = authorAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorSecondName() {
		return authorSecondName;
	}

	public void setAuthorSecondName(String authorSecondName) {
		this.authorSecondName = authorSecondName;
	}

	public int getAuthorAge() {
		return authorAge;
	}

	public void setAuthorAge(int authorAge) {
		this.authorAge = authorAge;
	}

	public AuthorDetail getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDetail author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "AuthorDetail [id=" + id + ", authorFirstName=" + authorFirstName + ", authorSecondName="
				+ authorSecondName + ", authorAge=" + authorAge + ", book=" + author + "]";
	}

}
