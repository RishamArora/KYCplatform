package com.example.KycPlatform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.KycPlatform.model.Customer;
import com.example.KycPlatform.service.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	 private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer customer, BindingResult bindingResult) throws Exception{
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errors");
		}
		return ResponseEntity.ok().body("User Created");
	}
	 
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable Long id) throws Exception{
		Customer cust = customerService.getCustomer(id);
		if(cust==null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Customer with this id");
		}
		return ResponseEntity.ok(cust);
		
	}
	 

}
