package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
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
		return addressBookList.get(contId - 1);
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) 
	{
		AddressBookData addressBookData = null;
		addressBookData=new AddressBookData(addressBookList.size()+1,addressBookDTO);
		addressBookList.add(addressBookData);
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
