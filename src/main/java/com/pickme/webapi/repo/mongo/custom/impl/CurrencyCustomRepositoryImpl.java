package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.Currency;
import com.pickme.webapi.repo.mongo.custom.CurrencyCustomRepository;

public class CurrencyCustomRepositoryImpl implements CurrencyCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public CurrencyCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteCurrency(String id) {
		Query queryString = new Query(Criteria.where("id").is(id));
        Update updateQuery = new Update();
        updateQuery.set("deleted", true);
        UpdateResult result = operations.updateFirst(queryString, updateQuery, Currency.class);
        return result.wasAcknowledged();
	}
}