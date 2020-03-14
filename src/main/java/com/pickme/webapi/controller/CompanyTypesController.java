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
import com.pickme.webapi.document.CompanyType;
import com.pickme.webapi.services.CompanyTypesService;

@RestController
@RequestMapping("/companyTypes")
@CrossOrigin
public class CompanyTypesController {
	
	@Autowired CompanyTypesService companyTypesService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<CompanyType>>> getAllCompanyTypes(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllCompanyTypes";
		Response<List<CompanyType>> response = new Response<List<CompanyType>>();
		try {			
				List<CompanyType> ctypes = companyTypesService.getAllCompanyTypes();  
				response.setData(ctypes);
				if(ctypes != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(ctypes.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_COMPANY_TYPES, CompanyTypesController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<CompanyType>>> responseEntity = new ResponseEntity<Response<List<CompanyType>>>(response,HttpStatus.OK);				
		return responseEntity;
	}
	/*
	 * public ResponseEntity<Response<List<CompanyTypes>>>
	 * getAllCompanyTypes(@RequestParam(value = "first", required = false) Integer
	 * first,
	 * 
	 * @RequestParam(value = "rows", required = false) Integer rows,
	 * 
	 * @RequestParam(value = "sortField", required = false) String sortOrder,
	 * 
	 * @RequestParam(value = "globalFilter", required = false) String globalFilter,
	 * 
	 * @RequestParam(value = "filters", required = false) String filters) { String
	 * METHOD_NAME = "getAllCompanyTypes";
	 * 
	 * Response<List<CompanyTypes>> response = new Response<List<CompanyTypes>>();
	 * try { response = companyTypesService.getAllCompanyTypes(first, rows,
	 * globalFilter, sortOrder);
	 * 
	 * if(response != null) { response.setStatusCode("0");
	 * response.setMessage(Response.SUCCESSFUL); response.setSuccessful(true);
	 * response.setMessageDetail(response.getData().size()+" Records Matched."); }
	 * else { response = new Response<List<CompanyTypes>>();
	 * response.setStatusCode("0"); response.setMessage(Response.SUCCESSFUL);
	 * response.setSuccessful(true);
	 * response.setMessageDetail("No Record Matched."); } } catch(Exception e) {
	 * response.setStatusCode("-1"); response.setMessage(Response.FAILED);
	 * response.setMessageDetail(e.getMessage());
	 * LOGGER.error(ApplicationConstants.MODULE_COMPANY_TYPES,
	 * CompanyTypesController.class.getName(), METHOD_NAME, e.getMessage(),
	 * ApplicationConstants.APPLICATION_NAME); }
	 * ResponseEntity<Response<List<CompanyTypes>>> responseEntity = new
	 * ResponseEntity<Response<List<CompanyTypes>>>(response,HttpStatus.OK); return
	 * responseEntity; }
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<CompanyType>> getCompanyTypesById(@PathVariable String id) {	
		String METHOD_NAME = "getCompanyTypesById";
		Response<CompanyType> response = new Response<CompanyType>();
		try {			
				CompanyType companyTypes = companyTypesService.getCompanyTypesById(id);
				response.setData(companyTypes);
				if(companyTypes != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Company Types by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Company Types Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY_TYPES, CompanyTypesController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<CompanyType>> responseEntity = new ResponseEntity<Response<CompanyType>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<CompanyType>> create(@RequestBody CompanyType companyType) {
		String METHOD_NAME = "create";
		Response<CompanyType> response =  new Response<CompanyType>();
		try {
				CompanyType existing = companyTypesService.getCompanyTypesByCompanyType(companyType.getCompanyType()); // Fix here
				if(existing == null) {
					CompanyType newCompanyType = companyTypesService.addCompanyType(companyType);
				    response.setData(newCompanyType);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("New Company Type Record is Created.");
				}
				else {
					response.setStatusCode("-1");
				    response.setMessage(Response.FAILED);
				    response.setSuccessful(false);
				    response.setMessageDetail("ERROR: Company Type already exist.");
				}    
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY_TYPES, CompanyTypesController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<CompanyType>> responseEntity = new ResponseEntity<Response<CompanyType>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<CompanyType>> update(@RequestBody CompanyType companyType) {
		String METHOD_NAME = "update";
		Response<CompanyType> response =  new Response<CompanyType>();
		try {
				CompanyType savedCompanyType = companyTypesService.updateCompanyTypes(companyType);
			    response.setData(savedCompanyType);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Company Types Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_COMPANY_TYPES, CompanyTypesController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<CompanyType>> responseEntity = new ResponseEntity<Response<CompanyType>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = companyTypesService.deleteCompanyTypes(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Company Types Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_COMPANY_TYPES, CompanyTypesController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
