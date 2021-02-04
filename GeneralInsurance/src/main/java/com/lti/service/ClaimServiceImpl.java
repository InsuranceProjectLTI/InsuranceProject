package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Claim;
import com.lti.entity.Insurance;
import com.lti.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;
	
	
	@Override
	public void addClaimService(Claim c) {
		
		try
		{
		claimRepository.addClaim(c);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Claim getClaimStatusByClaimIdService(int claimId) {
		
		Claim claim= new Claim();
		try
		{
			claim=claimRepository.getClaimStatusByClaimId(claimId);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public void updateClaimStatusByClaimIdService(Claim c) {
		
		try
		{
			claimRepository.updateClaimStatusByClaimId(c);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Claim> getClaimDetailByPolicyIdService(Insurance i) {

		List<Claim> claim=new ArrayList<Claim>();
		
		try
		{
			claim=claimRepository.getClaimDetailByPolicyId(i);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
