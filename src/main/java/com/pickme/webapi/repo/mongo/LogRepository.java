package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pickme.webapi.document.Log;
import com.pickme.webapi.repo.mongo.custom.LogCustomRepository;

public interface LogRepository extends MongoRepository<Log, String>,LogCustomRepository {
	
	/** Add Where clause with AND on each property **/
	@Query("{ 'module': ?0, 'className': ?1}")
	public List<Log> findAllWhere(String module, String className);
	/** Custom method Find by action Property **/
	public List<Log> findByModule(String module);
	/** Custom method Find by createdBy Property **/
	public List<Log> findByCreatedBy(String createdBy);
	/** Custom method Find by task Property **/
	public List<Log> findByClassName(String className);
}
