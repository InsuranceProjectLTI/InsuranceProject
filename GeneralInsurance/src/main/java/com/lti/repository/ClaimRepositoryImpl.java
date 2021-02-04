package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Claim;
import com.lti.entity.Insurance;

@Repository
public class ClaimRepositoryImpl implements ClaimRepository
{
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addClaim(Claim c) 
	{
		entityManager.persist(c);
	}
	
	@Transactional
	public Claim getClaimStatusByClaimId(int claimId) 
	{
		Claim c = entityManager.find(Claim.class, claimId);
		return c;
	}

	@Transactional
	public void updateClaimStatusByClaimId(Claim c) 
	{
		entityManager.merge(c);
	}

	@Transactional
	public List<Claim> getClaimDetailByPolicyId(Insurance i)
	{
		
	    Query q=entityManager.createQuery("select c from Claim c where c.insurance="+i.getPolicyNumber());
	    List<Claim> list1=q.getResultList();
	    return list1;
	}
}
