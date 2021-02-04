package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String address;

	@Column(name="CONTACT_NO")
	private String contactNo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	private String name;

	private String password;

	//bi-directional many-to-one association to Claim
	@OneToMany(mappedBy="customer")
	private List<Claim> claims;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="customer")
	private List<Vehicle> vehicles;

	public Customer() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setCustomer(this);

		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setCustomer(null);

		return claim;
	}

	@JsonIgnore
	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setCustomer(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setCustomer(null);

		return vehicle;
	}

}
