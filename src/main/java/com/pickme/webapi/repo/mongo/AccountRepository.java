package com.pickme.webapi.repo.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Account;




public interface AccountRepository extends MongoRepository<Account, String> {
	Page<Account> findAll(Pageable pageable);

}
