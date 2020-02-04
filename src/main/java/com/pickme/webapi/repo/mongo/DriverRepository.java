package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Driver;
import com.pickme.webapi.repo.mongo.custom.DriverCustomRepository;

public interface DriverRepository extends MongoRepository<Driver, String>, DriverCustomRepository {
	public List<Driver> findByDeleted(boolean deleted);
	public List<Driver> findAllBy(TextCriteria criteria);
	Driver findByLoginIdAndPasswordAndDeleted(String loginId,String password,boolean deleted);
	List<Driver> findByStatusAndDeleted(String status,boolean deleted);

}
