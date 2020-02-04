package com.pickme.webapi.repo.mongo.custom.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;

import com.pickme.webapi.document.Log;
import com.pickme.webapi.repo.mongo.custom.LogCustomRepository;

public class LogCustomRepositoryImpl implements LogCustomRepository {

	private final MongoOperations operations;
	
	@Autowired
	  public LogCustomRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }
	@Override
	public List<Log> searchLogs(String term) {
		Query searchQuery = new Query(); 
		// will search for properties action & task
		searchQuery.addCriteria(Criteria.where("module").is(term).orOperator(Criteria.where("className").is(term)));
		//searchQuery.addCriteria(Criteria.where("address.locality").is(locality));
		List<Log> logs = operations.find(searchQuery, Log.class);
		return logs;
	}

}
