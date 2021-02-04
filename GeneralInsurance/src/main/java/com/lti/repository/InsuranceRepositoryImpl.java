package com.lti.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;

@Repository
public class InsuranceRepositoryImpl implements InsuranceRepository {

	@PersistenceContext
	EntityManager entityManager; //CHEF
	
	@Transactional
	public List<Insurance> getAllInsurancePolicies() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(" from Insurance");
		List<Insurance> insurancePoliciesList = query.getResultList();
		return insurancePoliciesList;
	}


	@Transactional
	public void addInsurancePolicy(Insurance ip) {
		// TODO Auto-generated method stub
		ip.setPurchaseDate(new Date());
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, ip.getPlanDuration());
		Date currentDatePlusPlanDuration = c.getTime();
		ip.setExpiryDate(currentDatePlusPlanDuration);
		entityManager.persist(ip);
	}
	
	@Transactional
	public void renewInsurancePolicy(int policyId) {
		// TODO Auto-generated method stub
		Insurance i = new Insurance();
		i = entityManager.find(Insurance.class, policyId);
		
		i.setPurchaseDate(new Date());
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, i.getPlanDuration());
		Date currentDatePlusPlanDuration = c.getTime();
		i.setExpiryDate(currentDatePlusPlanDuration);
		
		entityManager.persist(i);
	}
	
	@Transactional
	public void updateInsurancePolicy(Insurance ip)
	{
		entityManager.merge(ip);
	}

	@Transactional 
	public Insurance getAllPolicyUsingPolicyId(int policyId) {
		// TODO Auto-generated method stub
		Insurance i = entityManager.find(Insurance.class, policyId);
		return i;
	}


	


}
