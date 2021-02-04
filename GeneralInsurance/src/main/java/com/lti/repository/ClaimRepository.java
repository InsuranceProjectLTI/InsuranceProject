package com.lti.repository;

import java.util.List;

import com.lti.entity.Claim;
import com.lti.entity.Insurance;

public interface ClaimRepository 
{
	void addClaim(Claim c);
	Claim getClaimStatusByClaimId(int claimId);
	void updateClaimStatusByClaimId(Claim c);
	List<Claim> getClaimDetailByPolicyId(Insurance i); 
}
