package com.lti.repository;

import com.lti.entity.Insurance;
import com.lti.entity.Payment;

public interface PaymentRepository 
{
	void addPayment(Payment p);
	Payment getPaymentByPolicyId(Insurance i);
}
