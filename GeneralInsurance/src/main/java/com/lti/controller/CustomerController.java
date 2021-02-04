package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Customer;
import com.lti.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getCustomers")
	@ResponseBody	
	public Customer getAllCustomerDetailsByEmailId(@RequestBody Customer cust)
	{
		Customer customerList = customerService.getCustomerByEmailService(cust.getEmail());
		return customerList;
	}
	
	@GetMapping("/getValidatedUser")
	@ResponseBody	
	public Customer getValidatedUser(@RequestBody Customer cust)
	{
		Customer customer = customerService.LoginUserService(cust.getEmail(), cust.getPassword());
		return customer;
	}
	@GetMapping("/getValidatedUser1")
	@ResponseBody	
	public String getValidatedUser1(@RequestBody Customer cust)
	{
		try {
			
		
		Customer customer = customerService.LoginUserService(cust.getEmail(), cust.getPassword());
		
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Valid Customer";
	}
	@PostMapping(path="/addCustomer")
	public String addCustomerDetails(@RequestBody Customer customer)
	{
		try
		{
		customerService.addCustomerService(customer);
		return "Customer Added..";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	@PutMapping(path="/updateCustomer")
	public String updateCustomerDetails(@RequestBody Customer customer)
	{
		try
		{
			customerService.updateCustomerService(customer);
			return "Details Update";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	@PutMapping(path="/forgotPassword")
	public void forgotPassword(@RequestBody Customer customer)
	{
		customerService.forgotPasswordService(customer.getEmail(), customer.getPassword());
	}
	@PutMapping(path="/resetPassword")
	public void resetPassword(@RequestBody Customer customer)
	{
		customerService.resetPasswordService(customer.getEmail(), customer.getPassword());
	}
	

}
