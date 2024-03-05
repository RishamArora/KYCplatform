package com.example.KycPlatform.Impl;

import java.sql.Date;

import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.KycPlatform.model.Customer;
import com.example.KycPlatform.model.CustomerKyc;
import com.example.KycPlatform.repository.CustomerKycRepository;
import com.example.KycPlatform.repository.CustomerRepository;
import com.example.KycPlatform.service.CustomerKycService;
import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public class CustomerKycImpl implements CustomerKycService {
	@Autowired 
	private CustomerKycRepository customerKycRepo;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerKyc createCustomer(Long id, MultipartFile aadhar, MultipartFile pan, String fname, String lname, String gender, Date DOB, String pincode, String phoneno, String aadharno, String panNo,String address) throws Exception{
		java.util.Optional<Customer> dbDataCustomer = customerRepository.findById(id) ;
		CustomerKyc dbDataCustomerKyc = customerKycRepo.findByCustomer(dbDataCustomer.get()) ;
		Customer customerEntity = null;
		CustomerKyc customerKycEntity=null;
		
		if(dbDataCustomerKyc == null) {
			customerEntity=dbDataCustomer.get();
			CustomerKyc cust = new CustomerKyc();
			try {
				cust.setFname(fname);
				cust.setLname(lname);
				cust.setGender(gender);
				cust.setPincode(pincode);
				cust.setDOB(DOB);
				cust.setAddress(address);
				cust.setAadharno(aadharno);
				cust.setPanNo(panNo);
				cust.setPan(pan.getBytes());
				cust.setAadhar(aadhar.getBytes());
				cust.setPhoneNo(phoneno);
				
			} catch (Exception e) {
				throw new Exception("Not created");
				// TODO: handle exception
			}
			return customerKycRepo.save(cust);
			
		}else {
			customerKycEntity= customerKycRepo.findByCustomer(dbDataCustomer.get());
			try {
				customerKycEntity.setFname(fname);
				customerKycEntity.setLname(lname);
				customerKycEntity.setGender(gender);
				customerKycEntity.setPincode(pincode);
				customerKycEntity.setDOB(DOB);
				customerKycEntity.setAddress(address);
				customerKycEntity.setAadharno(aadharno);
				customerKycEntity.setPanNo(panNo);
				customerKycEntity.setPan(pan.getBytes());
				customerKycEntity.setAadhar(aadhar.getBytes());
				customerKycEntity.setPhoneNo(phoneno);
			} catch (Exception e) {
				throw new Exception("Not Created");
			}
			return customerKycRepo.save(customerKycEntity);
		}
	}
	@Override
	public CustomerKyc getCustomerDetails(Long id) throws Exception {
		java.util.Optional<Customer> dbDataCustomer = customerRepository.findById(id);
		if(!dbDataCustomer.isPresent()) {
		 throw new Exception("Not Found");	
		}else {
			CustomerKyc cust = customerKycRepo.findByCustomer(dbDataCustomer.get());
			return cust;
		}
			
	}

}
