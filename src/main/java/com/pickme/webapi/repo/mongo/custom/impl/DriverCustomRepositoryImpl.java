package com.pickme.webapi.repo.mongo.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.repo.mongo.custom.DriverCustomRepository;

public class DriverCustomRepositoryImpl implements DriverCustomRepository {

private final MongoOperations operations;
	
	@Autowired
	  public DriverCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteDriver(String id) {
		Query query1 = new Query(Criteria.where("id").is(id));
        Update update1 = new Update();
        update1.set("deleted", true);
        UpdateResult result = operations.updateFirst(query1, update1, Customer.class);
        return result.wasAcknowledged();
	}
	@Override
	public List<Driver> search(String term) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
