package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INSURANCE database table.
 * 
 */
@Entity
@NamedQuery(name="Insurance.findAll", query="SELECT i FROM Insurance i")
public class Insurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POLICY_NUMBER")
	private int policyNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;

	@Column(name="PLAN_DURATION")
	private int planDuration;

	@Column(name="PLAN_TYPE")
	private String planType;

	@Temporal(TemporalType.DATE)
	@Column(name="PURCHASE_DATE")
	private Date purchaseDate;

	//bi-directional many-to-one association to Claim
	@OneToMany(mappedBy="insurance")
	private List<Claim> claims;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="REGISTRATION_NO")
	private Vehicle vehicle;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="insurance")
	private List<Payment> payments;

	public Insurance() {
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getPlanDuration() {
		return this.planDuration;
	}

	public void setPlanDuration(int i) {
		this.planDuration = i;
	}

	public String getPlanType() {
		return this.planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setInsurance(this);

		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setInsurance(null);

		return claim;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setInsurance(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setInsurance(null);

		return payment;
	}

}