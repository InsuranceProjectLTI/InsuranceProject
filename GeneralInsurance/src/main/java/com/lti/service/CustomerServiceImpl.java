package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void addCustomerService(Customer customer) {
		
		try
		{
			customerRepository.addCustomer(customer);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Customer getCustomerByEmailService(String email) {
		Customer customer=new Customer();
		try
		{
		customer=customerRepository.getCustomerByEmail(email);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@Override
	public void updateCustomerService(Customer customer) {
		
		try 
		{
			customerRepository.updateCustomer(customer);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void resetPasswordService(String email, String newPassword) {
		
		try
		{
			customerRepository.resetPassword(email, newPassword);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void forgotPasswordService(String email, String newPassword) {
		try
		{
			customerRepository.forgotPassword(email, newPassword);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Customer LoginUserService(String email, String password) {
		Customer cust = customerRepository.LoginUser(email);
		if(cust.getPassword().equals(password))
		{
			return cust;
		}
		else throw new RuntimeException("Invalid Credentials");
	}
}
