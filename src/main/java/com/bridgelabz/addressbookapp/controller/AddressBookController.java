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
	    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable("contId") int contId)
	    {
	    	AddressBookData contactData = null;
			contactData = new AddressBookData(2, new AddressBookDTO("Prajakta", "Nagpur"));
			ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", contactData);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	    }
		
	     @PostMapping("/create")
	     public ResponseEntity<ResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO)
	     {
	    	 AddressBookData contactData = null;
	 		contactData = new AddressBookData(3, addressBookDTO);
	 		ResponseDTO respDTO = new ResponseDTO("Created Address Book Contact Successfully", contactData);
	 		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	     } 
	     
	     @PutMapping("/update/{contId}")
	     public ResponseEntity<ResponseDTO> updateAddrressBookData(@RequestBody AddressBookDTO addressBookDTO)
         {
	    	 AddressBookData contactData = null;
	 		contactData = new AddressBookData(3, addressBookDTO);
	 		ResponseDTO respDTO = new ResponseDTO("Updated Address Book Contact Successfully", contactData);
	 		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	     }
	     
	     @DeleteMapping("/delete/{contId}")
	 	 public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contId") int contId)
	     {
	    	 ResponseDTO respDTO = new ResponseDTO("Deleted Address Book Contact Successfully", "Deleted Id: " + contId);
	 		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	   	 }
	}
