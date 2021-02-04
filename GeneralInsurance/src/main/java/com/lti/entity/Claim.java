package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLAIM_ID")
	private long claimId;

	@Column(name="CLAIM_AMOUNT")
	private int claimAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="CLAIM_DATE")
	private Date claimDate;

	@Column(name="CLAIM_REASON")
	private String claimReason;

	@Column(name="CLAIM_STATUS")
	private String claimStatus;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="EMAIL")
	private Customer customer;

	//bi-directional many-to-one association to Insurance
	@ManyToOne
	@JoinColumn(name="POLICY_NUMBER")
	private Insurance insurance;

	public Claim() {
	}

	public long getClaimId() {
		return this.claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public int getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(int i) {
		this.claimAmount = i;
	}

	public Date getClaimDate() {
		return this.claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimReason() {
		return this.claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getClaimStatus() {
		return this.claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

}
