package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService 
{

	@Override
	public List<AddressBookData> getAddressBookData() 
	{
		List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();
		addressBookList.add(new AddressBookData(1, new AddressBookDTO("Prajakta", "Amravati")));
		return addressBookList;
	}

}
