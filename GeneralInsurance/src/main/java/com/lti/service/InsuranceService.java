package com.lti.service;

import java.util.List;

import com.lti.entity.Insurance;

public interface InsuranceService {

	List<Insurance> getAllInsurancePoliciesService();
	Insurance getAllPolicyUsingPolicyIdService(int policyId);
	void addInsurancePolicyService(Insurance ip);
	void updateInsurancePolicyService(Insurance ip);
	void renewInsurancePolicyService(int policyId);
}
