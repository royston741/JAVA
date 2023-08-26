package com.student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.student.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends UserDTO{

	private String studentName;
	
	@Pattern(regexp = "^\\d{10}$", message = "Phone number should have 10 digits")
	private String phone;
	
	@Email
	private String email;
	
	private Address address;
}
