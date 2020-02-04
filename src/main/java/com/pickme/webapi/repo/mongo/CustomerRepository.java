package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Customer;
import com.pickme.webapi.repo.mongo.custom.CustomerCustomRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>,CustomerCustomRepository {
	public Customer findByPhone(String phone);
	public Customer findByPhoneAndEmail(String phone,String email);
	public List<Customer> findByDeleted(boolean deleted);
	Page<Customer> findByDeleted(boolean deleted, Pageable pageable);
	Customer findByIdAndPhoneAndDeleted(String id,String phone,boolean deleted);

}
