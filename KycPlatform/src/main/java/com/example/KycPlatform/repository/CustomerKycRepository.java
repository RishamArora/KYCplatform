package com.example.KycPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.KycPlatform.model.Customer;
import com.example.KycPlatform.model.CustomerKyc;

public interface CustomerKycRepository extends JpaRepository<CustomerKyc, Long>{
	CustomerKyc findByCustomer(Customer cust);

}
