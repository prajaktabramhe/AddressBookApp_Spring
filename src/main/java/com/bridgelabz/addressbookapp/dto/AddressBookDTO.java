package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

	public String name;
	public String address;
	

	public AddressBookDTO(String name, String address) 
	{
		super();
		this.setName(name);
		this.setAddress(address);
	}


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address)
	{
		this.address = address;
	}


	@Override
	public String toString() {
		return "AddressBookDTO [name=" + getName() + ", address=" + getAddress() + "]";
	}

}
