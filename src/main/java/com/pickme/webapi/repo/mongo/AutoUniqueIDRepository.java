package com.pickme.webapi.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.AutoUniqueID;
import com.pickme.webapi.document.User;

public interface AutoUniqueIDRepository extends MongoRepository<AutoUniqueID, String> {

	AutoUniqueID findBycount(Integer count);
}
