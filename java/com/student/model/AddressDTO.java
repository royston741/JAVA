package com.student.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	private int addressId;
	@NotNull(message="City name should not be null")
	@Size(min=3, message="City name should atleast be 3 character")
	private String city;
	
	@NotNull
	@Size(min=3, message="State name should atleast be 3 character")
	private String state;

	@Pattern(regexp = "^\\d{6}$", message = "Pincode should have 6 digits")
	private String pincode;
}
