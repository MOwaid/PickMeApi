package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Currency;
import com.pickme.webapi.repo.mongo.CurrencyRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class CurrencyService {

	@Autowired CurrencyRepository currencyRepo;
	@Autowired LogRepository logRepo;
	public List<Currency> getAllCurrency() {
		List<Currency> currency = currencyRepo.findByDeleted(false); 
		return currency;
	}
	public Currency getCurrencyById(String id) {
		Optional<Currency> currency = currencyRepo.findById(id);
		return currency.get();
	}
	public List<Currency> getCurrencyByCurrencyName(String currName) {
		List<Currency> currency=  currencyRepo.findByCurrencyName(currName);
		return currency;
	}
	public List<Currency> getCurrencyByCurrencyCode(String currCode) {
		List<Currency> currency=  currencyRepo.findByCurrencyCode(currCode);
		return currency;
	}
	public List<Currency> getCurrencyByCountryCode(String countryCode) {
		List<Currency> currency=  currencyRepo.findByCountryCode(countryCode);
		return currency;
	} 
	public List<Currency> getCurrencyByDollarXchangeRate(String dollarXchangeRate) {
		List<Currency> currency=  currencyRepo.findByDollarXchangeRate(dollarXchangeRate);
		return currency;
	}
	public List<Currency>  getCurrencyByCreatedBy(String createdBy) {
		List<Currency> currency=  currencyRepo.findByCreatedBy(createdBy);
		return currency;
	}
	public List<Currency>  getCurrencyByUpdatedBy(String updatedBy) {
		List<Currency> currency=  currencyRepo.findByUpdatedBy(updatedBy);
		return currency;
	}
	public Currency addCurrency(Currency currency) {
		Currency newCurrency = currencyRepo.insert(currency);
		return newCurrency;
	}
	public Currency updateCurrency(Currency currency) {
		Currency newCurrency = currencyRepo.save(currency);
		return newCurrency;
	}
	public boolean deleteCurrency(String id) {
		return currencyRepo.deleteCurrency(id);
	}
}