package com.example.KycPlatform.Impl;

import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.KycPlatform.model.Customer;
import com.example.KycPlatform.repository.CustomerRepository;
import com.example.KycPlatform.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Customer register(Customer cust) throws Exception {
		Customer existCustomer = customerRepository.findByEmail(cust.getEmail());
		if(existCustomer==null) {
			cust.setPassword(passwordEncoder.encode(cust.getPassword()));
			return customerRepository.save(cust);
		}
		throw new Exception("Email exists");
	}
	
	
	@Override
	public Customer getCustomer(Long id) throws Exception {
		java.util.Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		throw new Exception("Doesn't exists");
	}
	
	
	
	
	
	

}
