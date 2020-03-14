package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.Fare;
import com.pickme.webapi.repo.mongo.custom.FareCustomRepository;

public class FareCustomRepositoryImpl implements FareCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public FareCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteFare(String id) {
		Query queryString = new Query(Criteria.where("id").is(id));
        Update updateQuery = new Update();
        updateQuery.set("deleted", true);
        UpdateResult result = operations.updateFirst(queryString, updateQuery, Fare.class);
        return result.wasAcknowledged();
	}
}
	