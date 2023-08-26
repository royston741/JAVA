package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="student_details")
public class Student extends User{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	
	@Column(name="student_name", nullable=false)
	private String studentName;
	
	@Column(name="phone_no", nullable = false)
	private String phone; 
	
	@Column(nullable=false)
	private String email;
	
	@OneToOne
	private Address address;

	@Builder
	public Student(String studentName, String phone, String email) {
		super();
		this.studentName = studentName;
		this.phone = phone;
		this.email = email;
	}
	
	
}
