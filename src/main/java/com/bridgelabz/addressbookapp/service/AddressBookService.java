package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService 
{

	private List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();
	
	@Override
	public List<AddressBookData> getAddressBookData() 
	{
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookById(int contId) 
	{
		return addressBookList.stream().filter(bookData -> bookData.getAddressBookId() == contId).findFirst()
				.orElseThrow(() -> new AddressBookException("Addressbook entry Not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) 
	{
		AddressBookData addressBookData = null;
		addressBookData=new AddressBookData(addressBookList.size()+1,addressBookDTO);
		addressBookList.add(addressBookData);
		log.debug("Addressbook Data :" + addressBookData.toString());
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO)
	{
		AddressBookData addressBookData = this.getAddressBookById(contId);
		addressBookData.setName(addressBookDTO.name);
		addressBookData.setAddress(addressBookDTO.address);
		addressBookList.set(contId - 1, addressBookData );
		return addressBookData ;
	}

	@Override
	public void deleteAddressBookData(int contId) 
	{
		addressBookList.remove(contId - 1);
		
	}

}
