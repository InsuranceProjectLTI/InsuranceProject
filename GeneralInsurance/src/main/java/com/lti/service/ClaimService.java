package com.lti.service;

import java.util.List;

import com.lti.entity.Claim;
import com.lti.entity.Insurance;

public interface ClaimService {
	
	void addClaimService(Claim c);
	Claim getClaimStatusByClaimIdService(int claimId);
	void updateClaimStatusByClaimIdService(Claim c);
	List<Claim> getClaimDetailByPolicyIdService(Insurance i); 

}
