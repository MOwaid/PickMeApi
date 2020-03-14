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
import com.pickme.webapi.document.Fare;
import com.pickme.webapi.services.FareService;

@RestController
@RequestMapping("/fares")
@CrossOrigin
public class FareController {
	
	@Autowired FareService fareService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Fare>>> getAllFares(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllFares";
		Response<List<Fare>> response = new Response<List<Fare>>();
		try {			
				List<Fare> fares = fareService.getAllFares(); 
				response.setData(fares);
				if(fares != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(fares.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Fare>>> responseEntity = new ResponseEntity<Response<List<Fare>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Fare>> getFareById(@PathVariable String id) {	
		String METHOD_NAME = "getFareById";
		Response<Fare> response = new Response<Fare>();
		try {			
			Fare fare = fareService.getFareById(id);
			response.setData(fare);
			if(fare != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Fare by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Fare Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Fare>> responseEntity = new ResponseEntity<Response<Fare>>(response,HttpStatus.OK);				
		return responseEntity;		
	}

	@RequestMapping(value = "/{dayFare}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Fare>>> getFarebyDayFare(@PathVariable String dayFare) {	
		String METHOD_NAME = "getFarebyDayFare";
		Response<List<Fare>> response = new Response<List<Fare>>();
		try {			
				List<Fare> fares = fareService.getFareByDayFare(dayFare);
				response.setData(fares);
				if(fares != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Fares by Day Fare request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Found for Day Fare '"+dayFare+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Fare>>> responseEntity = new ResponseEntity<Response<List<Fare>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{nightFare}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Fare>>> getFarebyNightFare(@PathVariable String nightFare) {	
		String METHOD_NAME = "getFarebyNightFare";
		Response<List<Fare>> response = new Response<List<Fare>>();
		try {			
				List<Fare> fares = fareService.getFareByNightFare(nightFare);
				response.setData(fares);
				if(fares != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Fares by Night Fare request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Found for Day Fare '"+nightFare+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Fare>>> responseEntity = new ResponseEntity<Response<List<Fare>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{waitFare}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Fare>>> getFarebyWaitFare(@PathVariable String waitFare) {	
		String METHOD_NAME = "getFarebyWaitFare";
		Response<List<Fare>> response = new Response<List<Fare>>();
		try {			
				List<Fare> fares = fareService.getFareByWaitFare(waitFare);
				response.setData(fares);
				if(fares != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Fares by Wait Fare request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Found for Wait Fare '"+waitFare+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Fare>>> responseEntity = new ResponseEntity<Response<List<Fare>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{specialFee}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Fare>>> getFarebySpecialFee(@PathVariable String specialFee) {	
		String METHOD_NAME = "getFarebySpecialFee";
		Response<List<Fare>> response = new Response<List<Fare>>();
		try {			
				List<Fare> fares = fareService.getFareBySpecialFee(specialFee);
				response.setData(fares);
				if(fares != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Fares by Special Fee request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Found for Special Fee '"+specialFee+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Fare>>> responseEntity = new ResponseEntity<Response<List<Fare>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{specialDiscount}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Fare>>> getFarebySpecialDiscount(@PathVariable String specialDiscount) {	
		String METHOD_NAME = "getFarebySpecialDiscount";
		Response<List<Fare>> response = new Response<List<Fare>>();
		try {			
				List<Fare> fares = fareService.getFareBySpecialDiscount(specialDiscount);
				response.setData(fares);
				if(fares != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Fares by Special Discount request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Found for Special Discount '"+specialDiscount+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Fare>>> responseEntity = new ResponseEntity<Response<List<Fare>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Fare>> update(@RequestBody Fare fare) {
		String METHOD_NAME = "update";
		Response<Fare> response =  new Response<Fare>();
		try {
			Fare savedFare = fareService.updateFare(fare);
			response.setData(savedFare);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Fare Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_FARES, FareController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Fare>> responseEntity = new ResponseEntity<Response<Fare>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = fareService.deleteFare(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Fare Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, FareController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
