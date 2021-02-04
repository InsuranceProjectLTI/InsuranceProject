package com.lti.repository;

import com.lti.entity.Vehicle;
import java.util.List;

public interface VehicleRepository 
{
	void addVehicle(Vehicle v);
	void updateVehicleDetails(Vehicle v);
	Vehicle getVehiclesByRegNo(int regNo);
}
