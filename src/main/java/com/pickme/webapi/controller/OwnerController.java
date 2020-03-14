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
import com.pickme.webapi.document.Owner;
import com.pickme.webapi.services.OwnerService;

@RestController
@RequestMapping("/owners")
@CrossOrigin
public class OwnerController {
	
	@Autowired OwnerService ownerService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getAllOwners(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllOwners";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getAllOwners(); 
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(owners.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Owner>> getOwnerById(@PathVariable String id) {	
		String METHOD_NAME = "getOwnerById";
		Response<Owner> response = new Response<Owner>();
		try {			
				Owner owner = ownerService.getOwnerById(id);
				response.setData(owner);
				if(owner != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owner by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Owner>> responseEntity = new ResponseEntity<Response<Owner>>(response,HttpStatus.OK);				
		return responseEntity;		
	}

	@RequestMapping(value = "/{idNumber}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByIDNumber(@PathVariable String idNumber){
	/*, 
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) { */
		String METHOD_NAME = "getOwnersByIDNumber";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByIdentityNumber(idNumber); 
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(owners.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByFirstName(@PathVariable String firstName) {	
		String METHOD_NAME = "getOwnersByFirstName";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByFirstName(firstName);
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owner by First Name request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+firstName+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{lastName}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByLastName(@PathVariable String lastName) {	
		String METHOD_NAME = "getOwnersByLastName";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByLastName(lastName);
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owner by Last Name request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+lastName+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByEmail(@PathVariable String email) {	
		String METHOD_NAME = "getOwnersByEmail";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByEmail(email);
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owners by Email request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+email+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{businessNumber}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByBusinessNumber(@PathVariable String businessNumber) {	
		String METHOD_NAME = "getOwnersByBusinessNumber";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByBusinessNumber(businessNumber);
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owners by Business Number request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+businessNumber+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{mobileNumber}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByMobileNumber(@PathVariable String mobileNumber) {	
		String METHOD_NAME = "getOwnersByMobileNumber";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByMobileNumber(mobileNumber);
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owners by Mobile Number request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+mobileNumber+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{homeNumber}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Owner>>> getOwnersByHomeNumber(@PathVariable String homeNumber) {	
		String METHOD_NAME = "getOwnersByHomeNumber";
		Response<List<Owner>> response = new Response<List<Owner>>();
		try {			
				List<Owner> owners = ownerService.getOwnerByHomeNumber(homeNumber);
				response.setData(owners);
				if(owners != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Owners by Home Number request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Owner Record Found for ID '"+homeNumber+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Owner>>> responseEntity = new ResponseEntity<Response<List<Owner>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.POST) public
	 * ResponseEntity<Response<Owner>> create(@RequestBody Owner owner) { String
	 * METHOD_NAME = "create"; Response<Owner> response = new Response<Owner>(); try
	 * { Owner existing =
	 * ownerService.getOwnerByMobileNumber(owner.getMobileNumber()); if(existing ==
	 * null) { Owner newOwner = ownerService.addOwner(owner);
	 * response.setData(newOwner); response.setStatusCode("0");
	 * response.setMessage(Response.SUCCESSFUL); response.setSuccessful(true);
	 * response.setMessageDetail("New Owner Record is Created."); } else {
	 * response.setStatusCode("-1"); response.setMessage(Response.FAILED);
	 * response.setSuccessful(false);
	 * response.setMessageDetail("ERROR: Owner already exist."); } } catch(Exception
	 * ex) { response.setStatusCode("-1"); response.setMessage(Response.FAILED);
	 * response.setSuccessful(false);
	 * response.setMessageDetail("ERROR: "+ex.getMessage());
	 * LOGGER.error(ApplicationConstants.MODULE_OWNERS,
	 * OwnerController.class.getName(), METHOD_NAME, ex.getMessage(),
	 * ApplicationConstants.APPLICATION_NAME); } ResponseEntity<Response<Owner>>
	 * responseEntity = new ResponseEntity<Response<Owner>>(response,HttpStatus.OK);
	 * return responseEntity; }
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Owner>> update(@RequestBody Owner owner) {
		String METHOD_NAME = "update";
		Response<Owner> response =  new Response<Owner>();
		try {
				Owner savedOwner = ownerService.updateOwner(owner);
			    response.setData(savedOwner);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Owner Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Owner>> responseEntity = new ResponseEntity<Response<Owner>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = ownerService.deleteOwner(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Owner Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_OWNERS, OwnerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
