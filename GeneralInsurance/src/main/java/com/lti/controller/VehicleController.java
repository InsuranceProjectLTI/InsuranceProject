package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Vehicle;
import com.lti.service.VehicleService;

@RestController
@CrossOrigin
public class VehicleController 
{
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/getVehicle")
	@ResponseBody
	public Vehicle getVehiclesByRegNo(@RequestBody Vehicle v)
	{
		Vehicle vehicle = vehicleService.getVehiclesByRegNoService(v.getRegistrationNo());
		return vehicle;
	}
	
	@PostMapping("/addVehicle")
	@ResponseBody
	public String addVehicleService(@RequestBody Vehicle v)
	{
		try 
		{
			vehicleService.addVehicleService(v);
			return "Vehicle Added Successfully";
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
	}
	
	@PutMapping("/updateVehicle")
	@ResponseBody
	public String updateVehicleDetails(@RequestBody Vehicle v)
	{
		try 
		{
			vehicleService.updateVehicleDetailsService(v);;
			return "Vehicle Details Updated Successfully";
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
	}
}
