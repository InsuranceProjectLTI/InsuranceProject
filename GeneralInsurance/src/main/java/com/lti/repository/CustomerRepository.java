package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerRepository {

	
	void addCustomer(Customer customer);
	Customer getCustomerByEmail(String email);
	void updateCustomer(Customer customer);
	void resetPassword(String email,String newPassword);
	void forgotPassword(String email,String newPassword);
	Customer LoginUser(String email);
}
