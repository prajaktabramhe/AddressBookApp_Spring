package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.addressbookapp.service.IAddressBookService;

@RestController
@RequestMapping("/addressbookapp")

	public class AddressBookController 
	{
	
	@Autowired
	private IAddressBookService addressBookService;
	
	    @RequestMapping(value = { "", "/", "/get" })
		public ResponseEntity<ResponseDTO> getAddressBookData()
		{
	    	List<AddressBookData> addressBookData = addressBookService.getAddressBookData();
			ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", addressBookData);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
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
