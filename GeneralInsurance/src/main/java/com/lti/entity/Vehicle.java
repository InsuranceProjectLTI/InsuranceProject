package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VEHICLE database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REGISTRATION_NO")
	private int registrationNo;

	@Column(name="CHASSIS_NO")
	private int chassisNo;

	@Column(name="ENGINE_NO")
	private int engineNo;

	private String licence;

	private String manufacturer;

	private String model;

	@Temporal(TemporalType.DATE)
	@Column(name="PURCHASE_DATE")
	private Date purchaseDate;

	@Column(name="VEHICLE_TYPE")
	private String vehicleType;

	//bi-directional many-to-one association to Insurance
	@OneToMany(mappedBy="vehicle")
	private List<Insurance> insurances;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="EMAIL")
	private Customer customer;

	public Vehicle() {
	}

	public int getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = (int) registrationNo;
	}

	public int getChassisNo() {
		return this.chassisNo;
	}

	public void setChassisNo(int i) {
		this.chassisNo = i;
	}

	public int getEngineNo() {
		return this.engineNo;
	}

	public void setEngineNo(int i) {
		this.engineNo = i;
	}

	public String getLicence() {
		return this.licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@JsonIgnore
	public List<Insurance> getInsurances() {
		return this.insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public Insurance addInsurance(Insurance insurance) {
		getInsurances().add(insurance);
		insurance.setVehicle(this);

		return insurance;
	}

	public Insurance removeInsurance(Insurance insurance) {
		getInsurances().remove(insurance);
		insurance.setVehicle(null);

		return insurance;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}