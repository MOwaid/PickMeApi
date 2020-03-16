package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.DriverPrivilege;
import com.pickme.webapi.repo.mongo.custom.DriverPrivilegeCustomRepository;

public class DriverPrivilegeCustomRepositoryImpl implements DriverPrivilegeCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public DriverPrivilegeCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteDriverPrivilege(String id) {
		Query queryString = new Query(Criteria.where("id").is(id));
        Update updateQuery = new Update();
        updateQuery.set("deleted", true);
        UpdateResult result = operations.updateFirst(queryString, updateQuery, DriverPrivilege.class);
        return result.wasAcknowledged();
	}
}
	