package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Owner;
import com.pickme.webapi.repo.mongo.custom.OwnerCustomRepository;

public interface OwnerRepository extends MongoRepository<Owner, String>,OwnerCustomRepository {
	public List<Owner> findByIdentityNumber(String identityNumber);
	public List<Owner> findByFirstName(String firstName);
	public List<Owner> findByLastName(String lastName);
	public List<Owner> findByEmail(String email);
	public List<Owner> findByBusinessContactNumber(String businessNumber);
	public List<Owner> findByMobileNumber(String mobileNumber);
	public List<Owner> findByHomeNumber(String homeNumber);
	public List<Owner> findByCreatedBy(String createdBy);
	public List<Owner> findByUpdatedBy(String updatedBy);
	public List<Owner> findByDeleted(boolean deleted);
	Page<Owner> findByDeleted(boolean deleted, Pageable pageable);

}
