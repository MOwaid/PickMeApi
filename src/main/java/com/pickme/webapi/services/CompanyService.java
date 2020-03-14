package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Company;
import com.pickme.webapi.repo.mongo.CompanyRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class CompanyService {

	@Autowired CompanyRepository companyRepo;
	@Autowired LogRepository logRepo;
	public List<Company> getAllCompanies() {
		List<Company> companies = companyRepo.findByDeleted(false); 
		return companies;
	}
	
	public Company getCompanyById(String id) {
		Optional<Company> company = companyRepo.findById(id);
		return company.get();
	}
	public List<Company> getCompanyByCompanyName(String companyName) {
		List<Company> companies = companyRepo.findByCompanyName(companyName);
		return companies; 
	}
	public List<Company>  getOwnerByCreatedBy(String createdBy) {
		List<Company> companies=  companyRepo.findByCreatedBy(createdBy);
		return companies;
	}
	public List<Company>  getOwnerByUpdatedBy(String updatedBy) {
		List<Company> companies=  companyRepo.findByUpdatedBy(updatedBy);
		return companies;
	}
	public Company addCompany(Company company) {
		Company newCompany = companyRepo.insert(company);
		return newCompany;
	}
	public Company updateCompany(Company company) {
		Company newCompany = companyRepo.save(company);
		return newCompany;
	}
	public boolean deleteCompany(String id) {
		return companyRepo.deleteCompany(id);
	}
}