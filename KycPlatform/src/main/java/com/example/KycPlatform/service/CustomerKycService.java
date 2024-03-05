package com.example.KycPlatform.service;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.KycPlatform.model.CustomerKyc;

public interface CustomerKycService {
	CustomerKyc getCustomerDetails(Long id) throws Exception;
	
 CustomerKyc createCustomer(Long id, MultipartFile aadhar, MultipartFile pan, String fname, String lname, String gender, Date DOB, String pincode, String phoneno, String aadharno, String panNo,String address) throws Exception;
}
