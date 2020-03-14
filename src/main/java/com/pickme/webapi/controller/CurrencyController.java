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
import com.pickme.webapi.document.Currency;
import com.pickme.webapi.document.Owner;
import com.pickme.webapi.services.CurrencyService;

@RestController
@RequestMapping("/currency")
@CrossOrigin
public class CurrencyController {
	
	@Autowired CurrencyService currencyService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Currency>>> getAllCurrency(
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllCurrency";
		Response<List<Currency>> response = new Response<List<Currency>>();
		try {			
				List<Currency> currency = currencyService.getAllCurrency(); 
				response.setData(currency);
				if(currency != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(currency.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Currency>>> responseEntity = new ResponseEntity<Response<List<Currency>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Currency>> getCurrencyById(@PathVariable String id) {	
		String METHOD_NAME = "getCurrencyById";
		Response<Currency> response = new Response<Currency>();
		try {			
			Currency currency = currencyService.getCurrencyById(id);
			response.setData(currency);
			if(currency != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Currency by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Currency Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Currency>> responseEntity = new ResponseEntity<Response<Currency>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{currCode}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Currency>>> getCurrencyByCurrencyCode(@PathVariable String currCode) {	
		String METHOD_NAME = "getCurrencyByCurrencyCode";
		Response<List<Currency>> response = new Response<List<Currency>>();
		try {			
				List<Currency> currency = currencyService.getCurrencyByCurrencyCode(currCode);
				response.setData(currency);
				if(currency != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Currency by Currency Code request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Currency Record Found for Currency Code '"+currCode+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Currency>>> responseEntity = new ResponseEntity<Response<List<Currency>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{countryCode}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Currency>>> getCurrencyByCountryCode(@PathVariable String countryCode) {	
		String METHOD_NAME = "getCurrencyByCountryCode";
		Response<List<Currency>> response = new Response<List<Currency>>();
		try {			
				List<Currency> currency = currencyService.getCurrencyByCountryCode(countryCode);
				response.setData(currency);
				if(currency != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Currency by Country Code request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Currency Record Found for Country Code '"+countryCode+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Currency>>> responseEntity = new ResponseEntity<Response<List<Currency>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{currName}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Currency>>> getCurrencyByCurrencyName(@PathVariable String currName) {	
		String METHOD_NAME = "getCurrencyByCurrencyName";
		Response<List<Currency>> response = new Response<List<Currency>>();
		try {			
				List<Currency> currency = currencyService.getCurrencyByCurrencyName(currName);
				response.setData(currency);
				if(currency != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Currency by Currency Name request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Currency Record Found for Currency Name '"+currName+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Currency>>> responseEntity = new ResponseEntity<Response<List<Currency>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{dollarXchangeRate}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Currency>>> getCurrencyByExchangeRate(@PathVariable String dollarXchangeRate) {	
		String METHOD_NAME = "getCurrencyByExchangeRate";
		Response<List<Currency>> response = new Response<List<Currency>>();
		try {			
				List<Currency> currency = currencyService.getCurrencyByDollarXchangeRate(dollarXchangeRate);
				response.setData(currency);
				if(currency != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Currency by Dollar Exchange Rate request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Currency Record Found for Dollar Exchange Rate '"+dollarXchangeRate+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Currency>>> responseEntity = new ResponseEntity<Response<List<Currency>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Currency>> update(@RequestBody Currency currency) {
		String METHOD_NAME = "update";
		Response<Currency> response =  new Response<Currency>();
		try {
			Currency savedCurrency = currencyService.updateCurrency(currency);
			response.setData(savedCurrency);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Currency Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Currency>> responseEntity = new ResponseEntity<Response<Currency>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = currencyService.deleteCurrency(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Currency Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_CURRENCY, CurrencyController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
