package com.pickme.webapi.repo.mongo.custom;

import java.util.List;

import com.pickme.webapi.document.Log;

public interface LogCustomRepository {
	
	public List<Log> searchLogs(String term);
}
