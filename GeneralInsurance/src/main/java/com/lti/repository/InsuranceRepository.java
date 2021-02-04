package com.lti.repository;

import java.util.List;

import com.lti.entity.Insurance;

public interface InsuranceRepository {
	
	List<Insurance> getAllInsurancePolicies();
	Insurance getAllPolicyUsingPolicyId(int policyId);
	void addInsurancePolicy(Insurance ip);
	void updateInsurancePolicy(Insurance ip);
	void renewInsurancePolicy(int policyId);
}
