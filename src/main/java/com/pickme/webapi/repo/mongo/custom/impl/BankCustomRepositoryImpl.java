package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.Bank;
import com.pickme.webapi.repo.mongo.custom.BankCustomRepository;

public class BankCustomRepositoryImpl implements BankCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public BankCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteBank(String id) {
		Query query1 = new Query(Criteria.where("id").is(id));
        Update update1 = new Update();
        update1.set("deleted", true);
        UpdateResult result = operations.updateFirst(query1, update1, Bank.class);
        return result.wasAcknowledged();
	}
}
	