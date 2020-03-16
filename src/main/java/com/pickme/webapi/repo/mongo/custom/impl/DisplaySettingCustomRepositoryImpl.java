package com.pickme.webapi.repo.mongo.custom.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.pickme.webapi.document.DisplaySetting;
import com.pickme.webapi.repo.mongo.custom.DisplaySettingCustomRepository;

public class DisplaySettingCustomRepositoryImpl implements DisplaySettingCustomRepository{
private final MongoOperations operations;
	
	@Autowired
	  public DisplaySettingCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public boolean deleteDisplaySetting(String id) {
		Query queryString = new Query(Criteria.where("id").is(id));
        Update updateQuery = new Update();
        updateQuery.set("deleted", true);
        UpdateResult result = operations.updateFirst(queryString, updateQuery, DisplaySetting.class);
        return result.wasAcknowledged();
	}
}
	