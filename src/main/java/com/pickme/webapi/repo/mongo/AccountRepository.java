package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Account;
import com.pickme.webapi.repo.mongo.custom.AccountCustomRepository;

public interface AccountRepository extends MongoRepository<Account, String>, AccountCustomRepository {
	public Account findByCustomerNumber(String customerNumber);
	public Account findByIBAN(String iban);
	public Account findByCardNumber(String cardNumber);
	public Account findByAccountNumber(String accountNumber);
	public Account findByBranchCode(String branchCode);
	public Account findByCreatedBy(String createdBy);
	public Account findByUpdatedBy(String updatedBy);
	public List<Account> findByDeleted(boolean deleted);
	Page<Account> findByDeleted(boolean deleted, Pageable pageable);

}
