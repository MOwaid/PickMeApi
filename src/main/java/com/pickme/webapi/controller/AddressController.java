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

import com.pickme.webapi.common.AddressUtil;
import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.common.Logger;
import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Address;
import com.pickme.webapi.model.AddressSearchModel;
import com.pickme.webapi.services.AddressService;

@RestController
@RequestMapping("/addresses")
@CrossOrigin
public class AddressController {

	@Autowired AddressService addressService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Address>>> getAllAddresses(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllAddresses";
		Response<List<Address>> response = new Response<List<Address>>();
		List<Address> addresses = null;
		try {	
				if(globalFilter != null && globalFilter != "") {
					addresses = addressService.search(globalFilter);
				}
				else {
					addresses = addressService.getAllAddress();
				}			
				response.setData(addresses);
				if(addresses != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(addresses.size()+" Records Matched.");
				}
				else {
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
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Address>>> responseEntity = new ResponseEntity<Response<List<Address>>>(response,HttpStatus.OK);				
		return responseEntity;
	}
	@RequestMapping(value = "/strings", method = RequestMethod.GET)
	public ResponseEntity<Response<List<AddressSearchModel>>> getAllAddressesAsString(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllAddresses";
		Response<List<AddressSearchModel>> response = new Response<List<AddressSearchModel>>();
		List<Address> addresses = null;
		try {	
				if(globalFilter != null && globalFilter != "") {
					addresses = addressService.search(globalFilter);
				}
				else {
					addresses = addressService.getAllAddress();
				}			
				response.setData(AddressUtil.createAddressSearchModel(addresses));
				if(addresses != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(addresses.size()+" Records Matched.");
				}
				else {
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
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<AddressSearchModel>>> responseEntity = new ResponseEntity<Response<List<AddressSearchModel>>>(response,HttpStatus.OK);				
		return responseEntity;
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Address>>> search(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "term", required = true) String term) {
		String METHOD_NAME = "search";
		Response<List<Address>> response = new Response<List<Address>>();
		try {			
				List<Address> addresses = addressService.search(term);
				if(addresses != null && addresses.size()>0) {
					response.setData(addresses);
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(addresses.size()+" Records Matched.");
				}
				else {
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
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Address>>> responseEntity = new ResponseEntity<Response<List<Address>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Address>>> getAddressByCustomer(@PathVariable String id,
																		@RequestParam(value = "first", required = false) String first,
														  @RequestParam(value = "rows", required = false) String rows,
														  @RequestParam(value = "term", required = true) String term) {
		String METHOD_NAME = "getAddressByCustomer";
		Response<List<Address>> response = new Response<List<Address>>();
		try {
			List<Address> addresses = addressService.searchByCustomer(term,id);

			if(addresses != null && addresses.size()>0) {
				response.setData(addresses);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail(addresses.size()+" Records Matched.");
			}
			else {
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
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<List<Address>>> responseEntity = new ResponseEntity<Response<List<Address>>>(response,HttpStatus.OK);
		return responseEntity;
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Address>> getAddressById(@PathVariable String id) {	
		String METHOD_NAME = "getAddressById";
		Response<Address> response = new Response<Address>();
		try {			
				Address Address = addressService.getAddressById(id);
				response.setData(Address);
				if(Address != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Address by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Address Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Address>> responseEntity = new ResponseEntity<Response<Address>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Address>> create(@RequestBody Address Address) {
		String METHOD_NAME = "create";
		Response<Address> response =  new Response<Address>();
		try {
			    Address savedAddress = addressService.addAddress(Address);
			    response.setData(savedAddress);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Address Record is Created.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<Address>> responseEntity = new ResponseEntity<Response<Address>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Address>> update(@RequestBody Address Address) {
		String METHOD_NAME = "update";
		Response<Address> response =  new Response<Address>();
		try {
			    Address savedAddress = addressService.updateAddress(Address);
			    response.setData(savedAddress);
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
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Address>> responseEntity = new ResponseEntity<Response<Address>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = addressService.deleteAddress(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Address Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_Address, AddressController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}
}
