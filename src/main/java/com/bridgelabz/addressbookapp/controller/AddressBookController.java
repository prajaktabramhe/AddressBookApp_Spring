package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@RestController
@RequestMapping("/addressbookapp")

	public class AddressBookController 
	{

	    @RequestMapping(value = { "", "/", "/get" })
		public ResponseEntity<ResponseDTO> getAddressBookData()
		{
	    	AddressBookData contactData = null;
	    	contactData = new AddressBookData(1, new AddressBookDTO("Prajakta", "Tirupati"));
	    	ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}
		
	    @GetMapping("/get/{contId}")
	    public ResponseEntity<String> getAddressBookById(@PathVariable("contId") int contId)
	    {
	    	return new ResponseEntity<String>("Addressbook data by Id : "+contId,HttpStatus.OK);
	    }
		
	     @PostMapping("/create")
	     public ResponseEntity<String> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO)
	     {
	    	 return new ResponseEntity<String>("Address Book dto is " + addressBookDTO,HttpStatus.OK);
	     } 
	     
	     @PutMapping("/update/{contId}")
	     public ResponseEntity<String> updateAddrressBookData(@PathVariable("contId") int contId, @RequestBody AddressBookDTO addressBookDTO)
         {
	    	 return new ResponseEntity<String>("Updated address book of Id : "+contId+" "+addressBookDTO,HttpStatus.OK);
	     }
	     
	     @DeleteMapping("/delete/{contId}")
	 	 public ResponseEntity<String> deleteAddressBookData(@PathVariable("contId") int contId)
	     {
	 		return new ResponseEntity<String>("Deleted successfully the contact "+contId,HttpStatus.OK);
	   	 }
	}
