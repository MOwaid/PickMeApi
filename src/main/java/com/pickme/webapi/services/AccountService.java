package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Account;
import com.pickme.webapi.repo.mongo.AccountRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class AccountService {

	@Autowired AccountRepository accountRepo;
	@Autowired LogRepository logRepo;
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepo.findByDeleted(false); 
		return accounts;
	}
	
	public Account getAccountById(String id) {
		Optional<Account> account = accountRepo.findById(id);
		return account.get();
	}
	public Account getAccountByAccountNumber(String accountNumber) {
		return accountRepo.findByAccountNumber(accountNumber);
	}
	public Account getAccountByCustomerNumber(String customerNumber) {
		return accountRepo.findByCustomerNumber(customerNumber);
	}
	public Account getAccountByIBAN(String iban) {
		return accountRepo.findByIBAN(iban);
	}
	public Account getAccountByCardNumber(String cardNumber) {
		return accountRepo.findByCardNumber(cardNumber);
	}
	public Account getAccountByBranchCode(String branchCode) {
		return accountRepo.findByBranchCode(branchCode);
	}
	public Account getAccountsByCreatedBy(String createdBy) {
		return accountRepo.findByCreatedBy(createdBy);
	}
	public Account getAccountsByUpdatedBy(String updatedBy) {
		return accountRepo.findByUpdatedBy(updatedBy);
	}
	public Account addAccount(Account account) {
		Account newAccount = accountRepo.insert(account);
		return newAccount;
	}
	public Account updateAccount(Account account) {
		Account newAccount = accountRepo.save(account);
		return newAccount;
	}
	public boolean deleteAccount(String id) {
		return accountRepo.deleteAccount(id);
	}
}
