package com.lti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity.Claim;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;
import com.lti.repository.ClaimRepositoryImpl;
import com.lti.repository.CustomerRepositoryImpl;
import com.lti.repository.InsuranceRepositoryImpl;
import com.lti.repository.VehicleRepositoryImpl;

@SpringBootTest
class GeneralInsuranceApplicationTests {
	
	@Autowired
	VehicleRepositoryImpl vehicleRepository;

	@Test
	void contextLoads() throws ParseException			//Add Vehicle 
	{
		System.out.println("Running test : VehicleRepo : "+vehicleRepository);
		Vehicle v1 = new Vehicle();
		v1.setRegistrationNo(1001);
		v1.setChassisNo(10101);
		v1.setEngineNo(101);
		v1.setLicence("MP2020172000");
		v1.setManufacturer("Bajaj");
		v1.setModel("Splendor");
		v1.setPurchaseDate(new SimpleDateFormat("dd-MM-yyyy").parse("12-08-1997"));
		v1.setVehicleType("2 Wheeler");
		vehicleRepository.addVehicle(v1);
	}

	@Test
	void contextLoads2()								//Get Vehicles By Registration Number
	{
		System.out.println("Running test : VehicleRepo : "+vehicleRepository);
		Vehicle v2;
		
		v2 = vehicleRepository.getVehiclesByRegNo(1001);
		
			System.out.println("Registration Number : "+v2.getRegistrationNo());
			System.out.println("Chassis Number 		: "+v2.getChassisNo());
			System.out.println("Engine Number 		: "+v2.getEngineNo());
			System.out.println("License 			: "+v2.getLicence());
			System.out.println("Manufacturer 		: "+v2.getManufacturer());
			System.out.println("Model 				: "+v2.getModel());
			System.out.println("Purchase Date	 	: "+v2.getPurchaseDate());
			System.out.println("Vehicle Type 		: "+v2.getVehicleType());
	}
	
	@Test
	void contextLoads3()								// Updating Vehicles Details
	{
		System.out.println("Running test : VehicleRepo : "+vehicleRepository);
		Vehicle v3;
		v3 = vehicleRepository.getVehiclesByRegNo(1001);
		v3.setChassisNo(20202);
		vehicleRepository.updateVehicleDetails(v3);
	}
	
	@Autowired 
	InsuranceRepositoryImpl insuranceRepository;
	
	@Test
	void contextLoads4() 								// Add Insurance Policy
	{								
		System.out.println("running test : flightRepo : "+insuranceRepository);
		Insurance i1 = new Insurance();
		i1.setPlanType("2 Wheeler");
		i1.setPlanDuration(2);
		i1.setPurchaseDate(new Date());
		i1.setExpiryDate(new Date());
		insuranceRepository.addInsurancePolicy(i1);
	}
	
	@Test
	void contextLoads5()								// Get All Insurance Policy
	{
		System.out.println("running test : flightRepo : "+insuranceRepository);
		List<Insurance> policies;
		policies = insuranceRepository.getAllInsurancePolicies();
		for(Insurance policyDetails: policies)
		{
			System.out.println("Policy Id is: "+policyDetails.getPolicyNumber());
			System.out.println("Plan Type is: "+policyDetails.getPlanType());
			System.out.println("Plan Duration is:"+policyDetails.getPlanDuration());
			System.out.println("Plan Purchase Date is: "+policyDetails.getPurchaseDate());
			System.out.println("Plan Expiry Date is: "+policyDetails.getExpiryDate());
		}
	}
	
	@Test
	void contextLoads6()  //test case for Updating Insurance Policy
	{
		Insurance i2 = insuranceRepository.getAllPolicyUsingPolicyId(2);
		i2.setPlanDuration(1);
		i2.setPlanType("4 Wheeler");
		insuranceRepository.updateInsurancePolicy(i2);
	}
	
	@Autowired
	CustomerRepositoryImpl customerRepository;
	
	@Test
	void contextLoads7()  //test case to select a policy using policy id
	{
		Insurance i1 = insuranceRepository.getAllPolicyUsingPolicyId(2);
		System.out.println("Policy Number is: "+ i1.getPolicyNumber());
		System.out.println("Plan Type is :"+i1.getPlanType());
		System.out.println("Plan Duration is: "+i1.getPlanDuration()+" years.");
		System.out.println("Plan Purchase date is: "+i1.getPurchaseDate());
	}
	
	@Test
	void contextLoads8() throws ParseException 
	{
		Customer c = new Customer();
		c.setName("Manisha");
		c.setEmail("manisha@gmail.com");
		c.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("27-08-1997"));
		c.setAddress("KPHB Colony, Hyderabad");
		c.setContactNo("7095066655");
		c.setPassword("mani");
		customerRepository.addCustomer(c);
	}
	
	@Test
	void contextLoads9() 
	{	
		Customer c;
		c=customerRepository.getCustomerByEmail("sirisha@gmail.com");
			System.out.println(c.getName());
			System.out.println(c.getEmail());
			System.out.println(c.getDateOfBirth());
			System.out.println(c.getAddress());
			System.out.println(c.getContactNo());
			System.out.println(c.getPassword());
	}
	
	@Test
	void contextLoads10() 
	{
		Customer c;
		c=customerRepository.getCustomerByEmail("sirisha@gmail.com");
		c.setContactNo("9878657654");
		customerRepository.updateCustomer(c);
	}
	
	@Test
	void contextLoads11() 
	{
		customerRepository.resetPassword("sirisha@gmail.com","thakur");
	}
	
	@Test
	void contextLoads12() 
	{
		customerRepository.forgotPassword("sirisha@gmail.com","dharam");
	}
	
	@Autowired
	ClaimRepositoryImpl claimRepository;
	
	@Test
	void contextLoads13() 
	{
		System.out.println("Running test : ClaimRepo : "+claimRepository);
		Claim c = new Claim();
		
		c.setClaimAmount(2000);
		c.setClaimDate(new Date());
		c.setClaimReason("Man Made Disaster");
		c.setClaimStatus("Pending");
	}
	
	@Test
	void contextLoads14()		//ADMIN'S TEST
	{
		System.out.println("Running test : ClaimRepo : "+claimRepository);
		Claim c;
		
		c = claimRepository.getClaimStatusByClaimId(1);
		
		System.out.println("Claim Status : "+c.getClaimStatus());
	}
	
	@Test
	void contextLoads15()		//ADMIN'S TEST
	{
		System.out.println("Running test : ClaimRepo : "+claimRepository);
		Claim c;
		c = claimRepository.getClaimStatusByClaimId(1);
		c.setClaimStatus("Not Approved");
		claimRepository.updateClaimStatusByClaimId(c);
	}
	
	@Test
	void contextLoads16()
	{
		System.out.println("running test : InsuranceRepo : "+insuranceRepository);
		Customer c1 = new Customer();
		c1.setEmail("a@singh.com");
		c1.setAddress("Kalyan");
		c1.setContactNo("99999");
		c1.setDateOfBirth(new Date());
		c1.setName("Aman");
		c1.setPassword("qwerty");
		
		Vehicle v1 = new Vehicle();
		v1.setRegistrationNo(1010);
		v1.setChassisNo(1212);
		v1.setEngineNo(2121);
		v1.setLicence("MH05AS");
		v1.setManufacturer("TVS");
		v1.setModel("Apache");
		v1.setPurchaseDate(new Date());
		v1.setVehicleType("2 Wheeler");
		
		v1.setCustomer(c1);
		
		List<Vehicle> myVehicleList = new ArrayList<Vehicle>();
		myVehicleList.add(v1);
		
		c1.setVehicles(myVehicleList);
		
		System.out.println("Calling the DAO insert method of Customer Class");
		customerRepository.addCustomer(c1);
		vehicleRepository.addVehicle(v1);
	}
	
	@Test
	void contextLoads17()
	{
		Insurance i1 = new Insurance();
		i1.setPlanType("2 Wheeler");
		i1.setPlanDuration(2);
		i1.setPurchaseDate(new Date());
		i1.setExpiryDate(new Date());
		
		Vehicle v2 = new Vehicle();
		v2 = vehicleRepository.getVehiclesByRegNo(1001);
		
		i1.setVehicle(v2);
		
		List<Insurance> myInsuracePoliciesList = new ArrayList<Insurance>();
		myInsuracePoliciesList.add(i1);
		
		v2.setInsurances(myInsuracePoliciesList);
		
		System.out.println("Calling the DAO insert method");
		//vehicleRepository.addVehicle(v2);
		insuranceRepository.addInsurancePolicy(i1);
	}
	
	/*
	 * @Test void contextLoads18() // Login Verification {
	 * 
	 * List<Customer> customer=customerRepository.LoginUser("a@singh.com","qwerty");
	 * if(!(customer.isEmpty())) { System.out.println("Valid Credentials");
	 * for(Customer c : customer) { System.out.println(c.getName());
	 * System.out.println(c.getDateOfBirth()); System.out.println(c.getContactNo());
	 * System.out.println(c.getAddress()); } } else {
	 * System.out.println("Invalid Credentials"); } }
	 */
	
	@Test
	void contextLoads19()
	{
		Insurance insurance=insuranceRepository.getAllPolicyUsingPolicyId(22);
		List<Claim> l=claimRepository.getClaimDetailByPolicyId(insurance);
		for(Claim c:l)
		{
			System.out.println(c.getClaimId());
			System.out.println(c.getClaimReason());
			System.out.println(c.getClaimAmount());
			System.out.println(c.getClaimDate());
			System.out.println(c.getClaimStatus());
			System.out.println(c.getCustomer());
			System.out.println(c.getInsurance());
		}
	}
}
