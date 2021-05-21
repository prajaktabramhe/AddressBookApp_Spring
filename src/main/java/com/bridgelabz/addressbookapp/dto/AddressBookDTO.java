package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

	private String name;
	private String address;

	public AddressBookDTO(String name, String address) 
	{
		super();
		this.name = name;
		this.address = address;
	}
		
	@Override
	public String toString() {
		return "AddressBookDTO [name=" + name + ", address=" + address + "]";
	}
  
	
	
}
