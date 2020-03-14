package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Currency;
import com.pickme.webapi.repo.mongo.custom.CurrencyCustomRepository;

public interface CurrencyRepository extends MongoRepository<Currency, String>,CurrencyCustomRepository {
	public List<Currency> findByCurrencyCode(String currCode);
	public List<Currency> findByCurrencyName(String currName);
	public List<Currency> findByCountryCode(String countryCode);
	public List<Currency> findByDollarXchangeRate(String dollarXchangeRate);
	public List<Currency> findByCreatedBy(String createdBy);
	public List<Currency> findByUpdatedBy(String updatedBy);
	public List<Currency> findByDeleted(boolean deleted);
	Page<Currency> findByDeleted(boolean deleted, Pageable pageable);

}
