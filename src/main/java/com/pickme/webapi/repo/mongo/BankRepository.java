package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Bank;
import com.pickme.webapi.repo.mongo.custom.BankCustomRepository;

public interface BankRepository extends MongoRepository<Bank, String>,BankCustomRepository {
	public Bank findByBankCode(String bankCode);
	public Bank findByBankName(String bankName);
	public Bank findByCountryCode(String countryCode);
	public Bank findByCreatedBy(String createdBy);
	public Bank findByUpdatedBy(String updatedBy);
	public List<Bank> findByDeleted(boolean deleted);
	Page<Bank> findByDeleted(boolean deleted, Pageable pageable);

}
