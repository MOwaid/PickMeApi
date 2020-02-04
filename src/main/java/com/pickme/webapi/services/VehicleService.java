package com.pickme.webapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickme.webapi.document.Vehicle;
import com.pickme.webapi.repo.mongo.VehicleRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class VehicleService {

	@Autowired VehicleRepository vehicleRepo;
	@Autowired LogRepository logRepo;
	
	public List<Vehicle> search(String parameters) {
		return null;
	}
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = vehicleRepo.findByDeleted(false);
		return vehicles;
	}
	public Vehicle getVehicleById(String id) {
		Optional<Vehicle> vehicle = vehicleRepo.findById(id);
		return vehicle.get();
	}
	public Vehicle findVehicleById(String id) {
		return null;
	}
	public Vehicle addVehicle(Vehicle vehicle) {
		Vehicle newVehicle = vehicleRepo.insert(vehicle);
		return newVehicle;
	}
	public Vehicle updateVehicle(Vehicle vehicle) {
		Vehicle newVehicle = vehicleRepo.save(vehicle);
		return newVehicle;
	}
	public boolean deleteVehicle(String id) {
		return vehicleRepo.deleteVehicle(id);	
	}
}