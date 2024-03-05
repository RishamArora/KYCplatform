package com.example.KycPlatform.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.KycPlatform.model.CustomerKyc;
import com.example.KycPlatform.service.CustomerKycService;

@RestController
@CrossOrigin(origins="*")
public class CustomerKycController {
	
	@Autowired
	private CustomerKycService customerKycService;
	
	@GetMapping("/customers/id")
	public ResponseEntity<?> getCustomerDetails(@PathVariable("id") Long id) throws Exception{
		CustomerKyc cust = customerKycService.getCustomerDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(cust);
		
	}
	
	@PostMapping("/customers/CreateCustomer")
	public ResponseEntity<?> createCustomer(@PathVariable("id") Long id, @RequestParam("aadhar") MultipartFile aadhar,@RequestParam("pan") MultipartFile pan,@RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("address") String address,@RequestParam("pincode") String pincode,@RequestParam("gender") String gender,@RequestParam("DOB") Date DOB,@RequestParam("panNo") String panno,@RequestParam("phoneno") String phoneno,@RequestParam("aadharno") String aadharno) throws Exception{
		return ResponseEntity.ok().body(this.customerKycService.createCustomer(id, aadhar, pan, fname, lname, gender, DOB, pincode, phoneno, aadharno, panno, address));
	}
	


}
