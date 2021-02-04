package com.lti.service;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerService {
	
	void addCustomerService(Customer customer);
	Customer getCustomerByEmailService(String email);
	void updateCustomerService(Customer customer);
	void resetPasswordService(String email,String newPassword);
	void forgotPasswordService(String email,String newPassword);
	Customer LoginUserService(String email,String password);
	
}
