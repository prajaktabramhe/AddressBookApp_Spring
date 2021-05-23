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
	    	List<AddressBookData> addressBookList = null;
	    	addressBookList = addressBookService.getAddressBookData();
	    	ResponseDTO responseDTO = new ResponseDTO("Successfully got the data", addressBookList);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		
	    @GetMapping("/get/{contId}")
	    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable("contId") int contId)
	    {
	    	AddressBookData addressBookData = null;
	    	addressBookData = addressBookService.getAddressBookById(contId);
			ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: ", addressBookData);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		
	    }
		
	     @PostMapping("/create")
	     public ResponseEntity<ResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO)
	     {
	    	AddressBookData addressBookData = null;
	    	addressBookData = addressBookService.createAddressBookData(addressBookDTO);
	 		ResponseDTO responseDTO = new ResponseDTO("Successfully created the data ", addressBookData);
	 		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	 	}
	     	 	     
	     @PutMapping("/update/{contId}")
	     public ResponseEntity<ResponseDTO> updateAddrressBookData(@PathVariable("contId") int contId, @RequestBody AddressBookDTO addressBookDTO)
         {
	    	AddressBookData addressBookData = null;
	    	addressBookData = addressBookService.updateAddressBookData(contId, addressBookDTO);
	 		ResponseDTO responseDTO = new ResponseDTO("Updated address book of Id : ", addressBookData);
	 		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
         }
	     
	     @DeleteMapping("/delete/{contId}")
	 	 public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contId") int contId)
	     {
	    	addressBookService.deleteAddressBookData(contId);
	 		ResponseDTO responseDTO = new ResponseDTO("Deleted successfully the contact ", contId);
	 		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	   	 }
	}
