package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.AgentPrivilege;
import com.pickme.webapi.repo.mongo.custom.AgentPrivilegeCustomRepository;

public class AgentPrivilegeCustomRepositoryImpl implements AgentPrivilegeCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public AgentPrivilegeCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteAgentPrivilege(String id) {
		Query queryString = new Query(Criteria.where("id").is(id));
        Update updateQuery = new Update();
        updateQuery.set("deleted", true);
        UpdateResult result = operations.updateFirst(queryString, updateQuery, AgentPrivilege.class);
        return result.wasAcknowledged();
	}
}