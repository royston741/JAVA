package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // auto generating key
	@Column(name = "ID") // column named id
	private long id;

	// first name variable
	@Column(name = "FIRST_NAME")
	private String firstName;

	// second name variable
	@Column(name = "SECOND_NAME")
	private String lastName;

	// email address variable
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddr;

	@OneToOne(cascade = CascadeType.ALL) // one table to another table
	@JoinColumn(name = "COURSE_ID") // this column will act as a foreign key
	private Course course;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String emailAddr) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddr = emailAddr;
	}

	public long getStdId() {
		return id;
	}

	public void setStdId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddr="
				+ emailAddr + ", course=" + course + "]";
	}

}
