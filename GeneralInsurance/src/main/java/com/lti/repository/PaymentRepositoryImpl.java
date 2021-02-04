package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Insurance;
import com.lti.entity.Payment;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository  
{
	@PersistenceContext
	EntityManager entityManager;  //CHEF
	
	@Transactional
	public void addPayment(Payment p)
	{
		entityManager.persist(p);
	}
	
	@Transactional
	public Payment getPaymentByPolicyId(Insurance i)
	{
		Payment p = entityManager.find(Payment.class, i.getPolicyNumber());
		return p;
	}
}
