package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Bank;
import com.pickme.webapi.repo.mongo.BankRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class BankService {

	@Autowired BankRepository bankRepo;
	@Autowired LogRepository logRepo;
	public List<Bank> getAllBanks() {
		List<Bank> banks = bankRepo.findByDeleted(false); 
		return banks;
	}
	
	public Bank getBankById(String id) {
		Optional<Bank> bank = bankRepo.findById(id);
		return bank.get();
	}
	public Bank getBankByBankCode(String bankCode) {
		return bankRepo.findByBankCode(bankCode);
	}
	public Bank getBankByBankName(String bankName) {
		return bankRepo.findByBankName(bankName);
	}
	public Bank getBanksByCountryCode(String countryCode) {
		return bankRepo.findByCountryCode(countryCode);
	}
	public Bank getBanksByCreatedBy(String createdBy) {
		return bankRepo.findByCreatedBy(createdBy);
	}
	public Bank getBanksByUpdatedBy(String updatedBy) {
		return bankRepo.findByUpdatedBy(updatedBy);
	}
	public Bank addBank(Bank bank) {
		Bank newBank = bankRepo.insert(bank);
		return newBank;
	}
	public Bank updateBank(Bank bank) {
		Bank newBank = bankRepo.save(bank);
		return newBank;
	}
	public boolean deleteBank(String id) {
		return bankRepo.deleteBank(id);
	}
}
