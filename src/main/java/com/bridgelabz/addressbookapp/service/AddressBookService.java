package com.bridgelabz.addressbookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService 
{

	@Autowired
	private AddressBookRepository addressBookRepository;

	
	@Override
	public List<AddressBookData> getAddressBookData() 
	{
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookById(int contId) {
		return addressBookRepository.findById(contId)
				.orElseThrow(() -> new AddressBookException("Addressbook entry Not found"));
	}

		
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) 
	{
		AddressBookData addressBookData = null;
		addressBookData=new AddressBookData(addressBookDTO);
		log.debug("Addressbook Data :" + addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO)
	{
		AddressBookData addressBookData = this.getAddressBookById(contId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int contId) 
	{
		AddressBookData addressBookData = this.getAddressBookById(contId);
		addressBookRepository.delete(addressBookData);
		
	}

}
