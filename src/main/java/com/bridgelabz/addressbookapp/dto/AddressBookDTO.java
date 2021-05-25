package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@Pattern(regexp =  "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid name")
	public String name;
	
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid phone number")
	@NotEmpty(message = "Mobile number cannot be null")
	public String phoneNumber;
	
	@NotEmpty (message = "Address cannot be null")
	public String address;
	

	@NotBlank(message = "City should not be empty")
	public String city;

	@NotBlank(message = "State should not be empty")
	public String state;

	@Pattern(regexp="^[1-9]{1}[0-9]{5}$", message="Invalid zip code")
	public String zip;



}
