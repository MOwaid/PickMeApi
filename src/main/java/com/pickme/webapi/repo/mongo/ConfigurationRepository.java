package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Configuration;
import com.pickme.webapi.repo.mongo.custom.ConfigurationCustomRepository;

public interface ConfigurationRepository extends MongoRepository<Configuration, String>,ConfigurationCustomRepository {
	public List<Configuration> findByTimeZone(String timeZone);
	public List<Configuration> findByCreatedBy(String createdBy);
	public List<Configuration> findByUpdatedBy(String updatedBy);
	public List<Configuration> findByDeleted(boolean deleted);
	Page<Configuration> findByDeleted(boolean deleted, Pageable pageable);

}
