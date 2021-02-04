package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Transactional
	public Customer getCustomerByEmail(String email) {
		Customer customer=entityManager.find(Customer.class, email);
		return customer;
	}

	@Transactional
	public void updateCustomer(Customer customer) {

		entityManager.merge(customer);
	}

	@Transactional
	public void resetPassword(String email, String newPassword) {
		Customer customer = entityManager.find(Customer.class,email);
		customer.setPassword(newPassword);
		entityManager.merge(customer);
		
	}

	@Transactional
	public void forgotPassword(String email, String newPassword) {
		Customer customer = entityManager.find(Customer.class,email);
		customer.setPassword(newPassword);
		entityManager.merge(customer);
		
	}

	@Transactional
	public Customer LoginUser(String email) {
		Customer customer = entityManager.find(Customer.class, email);
		return customer;
	}

}
