package com.example.KycPlatform.service;

import com.example.KycPlatform.model.Customer;

public interface CustomerService {


	Customer register(Customer customer) throws Exception;
	Customer getCustomer(Long id) throws Exception;
	

}
