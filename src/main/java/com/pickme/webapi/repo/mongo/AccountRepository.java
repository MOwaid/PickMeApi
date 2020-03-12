package com.pickme.webapi.repo.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.CAccount;




public interface AccountRepository extends MongoRepository<CAccount, String> {
	Page<CAccount> findAll(Pageable pageable);

}
