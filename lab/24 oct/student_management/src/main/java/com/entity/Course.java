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
@Table(name = "Course")
public class Course {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // auto generating key
	@Column(name = "ID") // column named id
	private long id;

	// column name variable
	@Column(name = "COURSE_NAME")
	private String courseName;

	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
	private Student student;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", student=" + student + "]";
	}

}
