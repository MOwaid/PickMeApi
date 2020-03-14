package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.CompanyType;
import com.pickme.webapi.repo.mongo.custom.CompanyTypesCustomRepository;

public interface CompanyTypesRepository extends MongoRepository<CompanyType, String>,CompanyTypesCustomRepository {
	public CompanyType findByCompanyType(String companyType);
	public CompanyType findByCreatedBy(String createdBy);
	public CompanyType findByUpdatedBy(String updatedBy);
	public List<CompanyType> findByDeleted(boolean deleted);
	Page<CompanyType> findByDeleted(boolean deleted, Pageable pageable);

}
