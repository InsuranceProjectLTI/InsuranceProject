package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Vehicle;
import com.lti.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService
{
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public void addVehicleService(Vehicle v) 
	{
		try
		{
			vehicleRepository.addVehicle(v);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void updateVehicleDetailsService(Vehicle v) 
	{
		try
		{
			vehicleRepository.updateVehicleDetails(v);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Vehicle getVehiclesByRegNoService(int regNo) 
	{
		Vehicle vehicle = vehicleRepository.getVehiclesByRegNo(regNo);
		return vehicle;
	}
	
}
