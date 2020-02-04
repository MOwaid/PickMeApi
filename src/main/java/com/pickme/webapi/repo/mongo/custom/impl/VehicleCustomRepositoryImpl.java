package com.pickme.webapi.repo.mongo.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.repo.mongo.custom.VehicleCustomRepository;

public class VehicleCustomRepositoryImpl implements VehicleCustomRepository {

private final MongoOperations operations;
	
	@Autowired
	  public VehicleCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteVehicle(String id) {
		Query query1 = new Query(Criteria.where("id").is(id));
        Update update1 = new Update();
        update1.set("deleted", true);
        UpdateResult result = operations.updateFirst(query1, update1, Customer.class);
        return result.wasAcknowledged();
	}
}
