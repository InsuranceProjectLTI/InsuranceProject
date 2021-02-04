package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Insurance;
import com.lti.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Override
	public List<Insurance> getAllInsurancePoliciesService() {
		List<Insurance> listOfPolicies = null;
		try {
			listOfPolicies = insuranceRepository.getAllInsurancePolicies();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return listOfPolicies;
		
	}

	@Override
	public Insurance getAllPolicyUsingPolicyIdService(int policyId) {
		// TODO Auto-generated method stub
		Insurance insurance = new Insurance();
		try {
			insurance = insuranceRepository.getAllPolicyUsingPolicyId(policyId);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return insurance;
	}

	@Override
	public void addInsurancePolicyService(Insurance ip) {
		// TODO Auto-generated method stub
		try {
			insuranceRepository.addInsurancePolicy(ip);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateInsurancePolicyService(Insurance ip) {
		// TODO Auto-generated method stub
		try {
			insuranceRepository.updateInsurancePolicy(ip);;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void renewInsurancePolicyService(int policyId) {
		// TODO Auto-generated method stub
		try {
			insuranceRepository.renewInsurancePolicy(policyId);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	

}
