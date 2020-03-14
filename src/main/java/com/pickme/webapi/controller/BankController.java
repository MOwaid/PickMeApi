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
import com.pickme.webapi.services.BankService;

@RestController
@RequestMapping("/banks")
@CrossOrigin
public class BankController {
	
	@Autowired BankService bankService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Bank>>> getAllBanks(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllBanks";
		Response<List<Bank>> response = new Response<List<Bank>>();
		try {			
			List<Bank> banks = bankService.getAllBanks();  
			response.setData(banks);
			if(banks != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setMessageDetail(banks.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_BANKS , BankController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Bank>>> responseEntity = new ResponseEntity<Response<List<Bank>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Bank>> getBankById(@PathVariable String id) {	
		String METHOD_NAME = "getBankById";
		Response<Bank> response = new Response<Bank>();
		try {			
			Bank banks = bankService.getBankById(id); 
			response.setData(banks);
			if(banks != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Bank by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Bank Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BANKS, BankController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Bank>> responseEntity = new ResponseEntity<Response<Bank>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Bank>> create(@RequestBody Bank bank) {
		String METHOD_NAME = "create";
		Response<Bank> response =  new Response<Bank>();
		try {
			Bank existing = bankService.getBankByBankCode(bank.getBankCode());
			if(existing == null) {
				Bank newBank = bankService.addBank(bank);
			    response.setData(newBank);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Bank Record is Created.");
			}
			else {
				response.setStatusCode("-1");
			    response.setMessage(Response.FAILED);
			    response.setSuccessful(false);
			    response.setMessageDetail("ERROR: Bank already exist.");
			}    
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BANKS, BankController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<Bank>> responseEntity = new ResponseEntity<Response<Bank>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Bank>> update(@RequestBody Bank bank) {
		String METHOD_NAME = "update";
		Response<Bank> response =  new Response<Bank>();
		try {
			Bank savedBank = bankService.updateBank(bank);
			response.setData(savedBank);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Bank Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BANKS, BankController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Bank>> responseEntity = new ResponseEntity<Response<Bank>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = bankService.deleteBank(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Bank Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_BANKS, BankController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
