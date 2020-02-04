package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Vehicle;
import com.pickme.webapi.repo.mongo.custom.VehicleCustomRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String>, VehicleCustomRepository {
	public List<Vehicle> findByDeleted(boolean deleted);
}
