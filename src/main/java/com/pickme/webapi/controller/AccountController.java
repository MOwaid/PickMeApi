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
import com.pickme.webapi.document.Account;
import com.pickme.webapi.services.AccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {
	
	@Autowired AccountService accountService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Account>>> getAllAccounts(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllAccounts";
		Response<List<Account>> response = new Response<List<Account>>();
		try {			
				List<Account> accounts = accountService.getAllAccounts();  
				response.setData(accounts);
				if(accounts != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(accounts.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Account>>> responseEntity = new ResponseEntity<Response<List<Account>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Account>> getAccountById(@PathVariable String id) {	
		String METHOD_NAME = "getAccountById";
		Response<Account> response = new Response<Account>();
		try {			
			Account accounts = accountService.getAccountById(id);
			response.setData(accounts);
			if(accounts != null) {			
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
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/{custNum}", method = RequestMethod.GET)
	public ResponseEntity<Response<Account>> getAccountByCustomerNumber(@PathVariable String custNum) {	
		String METHOD_NAME = "getAccountByCustomerNumber";
		Response<Account> response = new Response<Account>();
		try {			
			Account accounts = accountService.getAccountByCustomerNumber(custNum);
			response.setData(accounts);
			if(accounts != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Account by Customer Number request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Account Record Found for Customer Number '"+custNum+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/{iban}", method = RequestMethod.GET)
	public ResponseEntity<Response<Account>> getAccountByIBAN(@PathVariable String iban) {	
		String METHOD_NAME = "getAccountByIBAN";
		Response<Account> response = new Response<Account>();
		try {			
			Account accounts = accountService.getAccountByIBAN(iban);
			response.setData(accounts);
			if(accounts != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Account by IBAN request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Account Record Found for IBAN '"+iban+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/{cardNum}", method = RequestMethod.GET)
	public ResponseEntity<Response<Account>> getAccountByCardNumber(@PathVariable String cardNum) {	
		String METHOD_NAME = "getAccountByCardNumber";
		Response<Account> response = new Response<Account>();
		try {			
			Account accounts = accountService.getAccountByCardNumber(cardNum);
			response.setData(accounts);
			if(accounts != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Account by Card Number request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Account Record Found for Card Number '"+cardNum+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/{accountNum}", method = RequestMethod.GET)
	public ResponseEntity<Response<Account>> getAccountByAccountNumber(@PathVariable String accountNum) {	
		String METHOD_NAME = "getAccountByAccountNumber";
		Response<Account> response = new Response<Account>();
		try {			
			Account accounts = accountService.getAccountByAccountNumber(accountNum);
			response.setData(accounts);
			if(accounts != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Account by Account Number request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Account Record Found for Account Number '"+accountNum+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	
	@RequestMapping(value = "/{branchCode}", method = RequestMethod.GET)
	public ResponseEntity<Response<Account>> getAccountByBranchCode(@PathVariable String branchCode) {	
		String METHOD_NAME = "getAccountByBranchCode";
		Response<Account> response = new Response<Account>();
		try {			
			Account accounts = accountService.getAccountByBranchCode(branchCode);
			response.setData(accounts);
			if(accounts != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Account by Branch Code request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Account Record Found for Branch Code '"+branchCode+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Account>> create(@RequestBody Account account) {
		String METHOD_NAME = "create";
		Response<Account> response =  new Response<Account>();
		try {
			Account existing = accountService.getAccountByAccountNumber(account.getAccountNumber()); // add more conditions to find unique record
			if(existing == null) {
				Account newAccount = accountService.addAccount(account);
			    response.setData(newAccount);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Account Record is Created.");
			}
			else {
				response.setStatusCode("-1");
			    response.setMessage(Response.FAILED);
			    response.setSuccessful(false);
			    response.setMessageDetail("ERROR: Account already exist.");
			}    
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Account>> update(@RequestBody Account account) {
		String METHOD_NAME = "update";
		Response<Account> response =  new Response<Account>();
		try {
			Account savedAccount = accountService.updateAccount(account);
			response.setData(savedAccount);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Account Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Account>> responseEntity = new ResponseEntity<Response<Account>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = accountService.deleteAccount(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Account Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_ACCOUNTS, AccountController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
