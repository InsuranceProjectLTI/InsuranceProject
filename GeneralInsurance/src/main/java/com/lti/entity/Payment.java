package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PAYMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAYMENT_ID")
	private BigDecimal paymentId;

	//bi-directional many-to-one association to Insurance
	@ManyToOne
	@JoinColumn(name="POLICY_NUMBER")
	private Insurance insurance;

	public Payment() {
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(BigDecimal paymentId) {
		this.paymentId = paymentId;
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

}