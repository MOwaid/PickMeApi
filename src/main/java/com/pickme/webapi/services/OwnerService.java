package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Owner;
import com.pickme.webapi.repo.mongo.OwnerRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class OwnerService {

	@Autowired OwnerRepository ownerRepo;
	@Autowired LogRepository logRepo;
	public List<Owner> getAllOwners() {
		List<Owner> owners = ownerRepo.findByDeleted(false); 
		return owners;
	}
	
	public Owner getOwnerById(String id) {
		Optional<Owner> owner = ownerRepo.findById(id);
		return owner.get();
	}
	public List<Owner> getOwnerByIdentityNumber(String idNumber) {
		List<Owner> owners = ownerRepo.findByIdentityNumber(idNumber);
		return owners;
	}
	public List<Owner> getOwnerByFirstName(String firstName) {
		List<Owner> owners = ownerRepo.findByFirstName(firstName);
		return owners;
	}
	public List<Owner> getOwnerByLastName(String lastName) {
		List<Owner> owners= ownerRepo.findByLastName(lastName);
		return owners;
	}
	public List<Owner> getOwnerByEmail(String email) {
		List<Owner> owners=  ownerRepo.findByEmail(email);
		return owners;
	}
	public List<Owner>  getOwnerByBusinessNumber(String businessNumber) {
		List<Owner> owners=  ownerRepo.findByBusinessContactNumber(businessNumber);
		return owners;
	}
	public List<Owner>  getOwnerByMobileNumber(String mobileNumber) {
		List<Owner> owners=  ownerRepo.findByMobileNumber(mobileNumber);
		return owners;
	}
	public List<Owner>  getOwnerByHomeNumber(String homeNumber) {
		List<Owner> owners=  ownerRepo.findByHomeNumber(homeNumber);
		return owners;
	}
	public List<Owner>  getOwnerByCreatedBy(String createdBy) {
		List<Owner> owners=  ownerRepo.findByCreatedBy(createdBy);
		return owners;
	}
	public List<Owner>  getOwnerByUpdatedBy(String updatedBy) {
		List<Owner> owners=  ownerRepo.findByUpdatedBy(updatedBy);
		return owners;
	}
	public Owner addOwner(Owner Owner) {
		Owner newOwner = ownerRepo.insert(Owner);
		return newOwner;
	}
	public Owner updateOwner(Owner Owner) {
		Owner newOwner = ownerRepo.save(Owner);
		return newOwner;
	}
	public boolean deleteOwner(String id) {
		return ownerRepo.deleteOwner(id);
	}
}
