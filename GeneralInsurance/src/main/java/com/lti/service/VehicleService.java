package com.lti.service;

import com.lti.entity.Vehicle;

public interface VehicleService 
{
	void addVehicleService(Vehicle v);
	void updateVehicleDetailsService(Vehicle v);
	Vehicle getVehiclesByRegNoService(int regNo);
}
