package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Insurance;
import com.lti.service.InsuranceService;

@RestController
@CrossOrigin
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;
	
	@GetMapping("/getInsurance")
	@ResponseBody
	public Insurance getInsuranceByPolicyId(@RequestBody Insurance ins)
	{
		Insurance insurance = insuranceService.getAllPolicyUsingPolicyIdService(ins.getPolicyNumber());
		return insurance;
	}
	
	@PostMapping("/addInsurance")
	public String addInsurance(@RequestBody Insurance ins)
	{
		try {
			insuranceService.addInsurancePolicyService(ins);
			return "Insuance Added Successfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	@PostMapping("/renewInsurance")
	public String renewInsurance(@RequestBody Insurance ins)
	{
		try {
			insuranceService.renewInsurancePolicyService(ins.getPolicyNumber());
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Insurance Policy Updated";
	}
}
