package com.lti.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository
{
	@PersistenceContext
	EntityManager entityManager;  //CHEF
	
	@Transactional
	public void addVehicle(Vehicle v)
	{
		entityManager.persist(v);
	}
	
	@Transactional
	public Vehicle getVehiclesByRegNo(int regNo)
	{
		Vehicle v = entityManager.find(Vehicle.class, regNo);
		return v;
	}

	@Transactional
	public void updateVehicleDetails(Vehicle v) 
	{
		entityManager.merge(v);
		
	}
	
	
}
