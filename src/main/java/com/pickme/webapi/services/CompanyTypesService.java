package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.CompanyType;
import com.pickme.webapi.repo.mongo.CompanyTypesRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class CompanyTypesService {

	@Autowired CompanyTypesRepository companyTypesRepo;
	@Autowired LogRepository logRepo;
	public List<CompanyType> getAllCompanyTypes() {
		List<CompanyType> ctypes = companyTypesRepo.findByDeleted(false); //vehicleRepo.findByDeleted(false);
		return ctypes;
	}
	
	public CompanyType getCompanyTypesById(String id) {
		Optional<CompanyType> companyTypes = companyTypesRepo.findById(id);
		return companyTypes.get();
	}
	public CompanyType getCompanyTypesByCompanyType(String companyType) {
		return companyTypesRepo.findByCompanyType(companyType);
	}
	public CompanyType getCompanyTypesByCreatedBy(String createdBy) {
		return companyTypesRepo.findByCreatedBy(createdBy);
	}
	public CompanyType getCompanyTypesByUpdatedBy(String updatedBy) {
		return companyTypesRepo.findByUpdatedBy(updatedBy);
	}
	public CompanyType addCompanyType(CompanyType companyType) {
		CompanyType newCompanyType = companyTypesRepo.insert(companyType);
		return newCompanyType;
	}
	public CompanyType updateCompanyTypes(CompanyType companyType) {
		CompanyType newCompanyType = companyTypesRepo.save(companyType);
		return newCompanyType;
	}
	public boolean deleteCompanyTypes(String id) {
		return companyTypesRepo.deleteCompanyTypes(id);
	}
}
