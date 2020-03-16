package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.Account;
import com.pickme.webapi.repo.mongo.custom.AccountCustomRepository;

public class AccountCustomRepositoryImpl implements AccountCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public AccountCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteAccount(String id) {
		Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("deleted", true);
        UpdateResult result = operations.updateFirst(query, update, Account.class);
        return result.wasAcknowledged();
	}
}
	