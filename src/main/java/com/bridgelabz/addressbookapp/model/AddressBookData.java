package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

public class AddressBookData 
{
	private int addressBookId;
	private String name;
	private String address;

	public AddressBookData() {
	}
	
	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		this.addressBookId = addressBookId;
		this.name = addressBookDTO.getName();
		this.address = addressBookDTO.getAddress();
	}

	public int getAddressBookId() 
	{
		return addressBookId;
	}

	public void setAddressBookId(int addressBookId) 
	{
		this.addressBookId = addressBookId;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
		
	}
	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	
}
