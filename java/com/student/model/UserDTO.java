package com.student.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	//private int id;
	
	@NotNull
	@Size(min=2, message= "username should have minimum 2 characters")
	private String userName;
	
	@NotNull
	@Size(min=2, message= "password should have minimum 2 characters")
	private String password;
	
	@NotNull
	private String role;
}
