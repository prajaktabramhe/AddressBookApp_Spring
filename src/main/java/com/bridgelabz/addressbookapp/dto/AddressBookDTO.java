package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

	private String name;
	private String address;
	

	public AddressBookDTO(String name, String address) 
	{
		super();
		this.setName(name);
		this.setAddress(address);
	}
<<<<<<< HEAD
		
	@Override
	public String toString() {
		return "AddressBookDTO [name=" + name + ", address=" + address + "]";
	}
  
	
	
=======


	@Override
	public String toString() {
		return "AddressBookDTO [name=" + getName() + ", address=" + getAddress() + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



>>>>>>> UC3_IntroduceDTO_Model_AddressBookApp
}
