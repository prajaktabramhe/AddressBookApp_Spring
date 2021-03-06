package com.bridgelabz.addressbookapp.service;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

public interface IAddressBookService 
{

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookById(int contId);
	
	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO);
	
	void deleteAddressBookData(int contId);

			
}
