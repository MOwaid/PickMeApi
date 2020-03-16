package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Company;
import com.pickme.webapi.repo.mongo.custom.CompanyCustomRepository;

public interface CompanyRepository extends MongoRepository<Company, String>,CompanyCustomRepository {
	public List<Company> findByCompanyName(String companyName);
	public List<Company> findByCreatedBy(String createdBy);
	public List<Company> findByUpdatedBy(String updatedBy);
	public List<Company> findByDeleted(boolean deleted);
	Page<Company> findByDeleted(boolean deleted, Pageable pageable);

}
