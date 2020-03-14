package com.pickme.webapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.common.Logger;
import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Bank;
import com.pickme.webapi.document.Company;
import com.pickme.webapi.services.CompanyService;

@RestController
@RequestMapping("/companies")
@CrossOrigin
public class CompanyController {
	
	@Autowired CompanyService companyService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Company>>> getAllCompanies(
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllCompanies";
		Response<List<Company>> response = new Response<List<Company>>();
		try {			
				List<Company> companies = companyService.getAllCompanies(); 
				response.setData(companies);
				if(companies != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(companies.size()+" Records Matched.");
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail("No Record Matched.");
				}
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY, CompanyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Company>>> responseEntity = new ResponseEntity<Response<List<Company>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Company>> getCompanyById(@PathVariable String id) {	
		String METHOD_NAME = "getCompanyById";
		Response<Company> response = new Response<Company>();
		try {			
			Company company = companyService.getCompanyById(id);
			response.setData(company);
			if(company != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Company by ID request was Successful.");			
			}
			else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Company Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY, CompanyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Company>> responseEntity = new ResponseEntity<Response<Company>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
////////////////////////////////////////////////////////////
	@RequestMapping(value = "/{companyName}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Company>>> getCompaniesByCompanyName(@PathVariable String companyName) {	
		String METHOD_NAME = "getCompaniesByCompanyName";
		Response<List<Company>> response = new Response<List<Company>>();
		try {			
				List<Company> companies = companyService.getCompanyByCompanyName(companyName);
				response.setData(companies);
				if(companies != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Companies by Company Name request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Company Record Found for Company Name '"+companyName+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY, CompanyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Company>>> responseEntity = new ResponseEntity<Response<List<Company>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
///////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Company>> create(@RequestBody Company company) {
		String METHOD_NAME = "create";
		Response<Company> response =  new Response<Company>();
		try {
			//Company existing = companyService 
			String existing = null;
			if(existing == null) {
				Company newCompany = companyService.addCompany(company);
			    response.setData(newCompany);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Company Record is Created.");
			}
			else {
				response.setStatusCode("-1");
			    response.setMessage(Response.FAILED);
			    response.setSuccessful(false);
			    response.setMessageDetail("ERROR: Company already exist.");
			}    
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY, CompanyController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<Company>> responseEntity = new ResponseEntity<Response<Company>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Company>> update(@RequestBody Company company) {
		String METHOD_NAME = "update";
		Response<Company> response =  new Response<Company>();
		try {
			Company savedCompany = companyService.updateCompany(company);
			response.setData(savedCompany);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Company Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY, CompanyController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Company>> responseEntity = new ResponseEntity<Response<Company>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = companyService.deleteCompany(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Company Record has been deleted.");
			    }
			    else {
			    	response.setData(id);
				    response.setStatusCode("-1");
				    response.setMessage(Response.FAILED);
				    response.setSuccessful(false);
				    response.setMessageDetail("Delete Operation was not Successful.");
			    }
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY, CompanyController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
