package com.pickme.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.common.Logger;
import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.CAccount;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.services.CAccountService;

@RestController
@RequestMapping("/customerAccounts")
public class CAccountController {
	@Autowired CAccountService accountService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<CAccount>>> getAllAccounts(@RequestParam(value = "first", required = false) Integer first,
		    @RequestParam(value = "rows", required = false) Integer rows,
		    @RequestParam(value = "sortField", required = false) String sortOrder,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllAccounts";
		
		Response<List<CAccount>> response = new Response<List<CAccount>>();
		try {			
				response = accountService.getAllAccounts(first,rows,globalFilter,sortOrder);
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(response.getData().size()+" Records Matched.");
				}
				else {
					response = new Response<List<CAccount>>();
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Matched.");
				}
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CACCOUNT, CAccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<CAccount>>> responseEntity = new ResponseEntity<Response<List<CAccount>>>(response,HttpStatus.OK);				
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<CAccount>> create(@RequestBody CAccount Account) {
		String METHOD_NAME = "create";
		Response<CAccount> response =  new Response<CAccount>();
		try {
			CAccount savedacc = accountService.create(Account);
			    response.setData(savedacc);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Account Record is Created.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CACCOUNT, AddressController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<CAccount>> responseEntity = new ResponseEntity<Response<CAccount>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<CAccount>> update(@RequestBody CAccount Account) {
		String METHOD_NAME = "update";
		Response<CAccount> response =  new Response<CAccount>();
		try {
				CAccount savedAcc = accountService.updateAccount(Account);
			    response.setData(savedAcc);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Address Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CACCOUNT, AddressController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<CAccount>> responseEntity = new ResponseEntity<Response<CAccount>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<CAccount>> getAccountById(@PathVariable String id) {	
		String METHOD_NAME = "getAccountById";
		Response<CAccount> response = new Response<CAccount>();
		try {			
			CAccount account = accountService.getAccountById(id);
				response.setData(account);
				if(account != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Account by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Account Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CACCOUNT, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<CAccount>> responseEntity = new ResponseEntity<Response<CAccount>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/status/", method = RequestMethod.PUT)
	public ResponseEntity<Response<CAccount>> updateAccountByStatus(@RequestBody CAccount account) {
		String METHOD_NAME = "updateAccountByStatus";
		Response<CAccount> response = new Response<CAccount>();
		CAccount accountResponse=null;
		try {
			accountResponse = accountService.updateAccountStatus(account);
			//response.setData(booking);
			if(accountResponse != null) {
				response.setData(accountResponse);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking status successfully updated.");
			}
			else {

				response.setStatusCode("-1");
				response.setMessage(Response.FAILED);
				response.setSuccessful(false);
				response.setMessageDetail("Invalid Request");
			}
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CACCOUNT, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<CAccount>> responseEntity = new ResponseEntity<Response<CAccount>>(response,HttpStatus.OK);
		return responseEntity;
	}

	
	
}
