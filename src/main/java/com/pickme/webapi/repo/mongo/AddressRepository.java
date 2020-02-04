package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pickme.webapi.document.Address;
import org.springframework.data.mongodb.repository.support.QuerydslMongoPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AddressRepository extends MongoRepository<Address, String> {

	public List<Address> findByDeleted(boolean deleted);
	public List<Address> findAllBy(TextCriteria criteria);
	List<Address> findByCompleteAddressLike(String text);
}
