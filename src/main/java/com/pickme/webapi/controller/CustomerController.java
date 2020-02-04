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
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.services.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Customer>>> getAllCustomers(@RequestParam(value = "first", required = false) Integer first,
		    @RequestParam(value = "rows", required = false) Integer rows,
		    @RequestParam(value = "sortField", required = false) String sortOrder,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllCustomers";
		
		Response<List<Customer>> response = new Response<List<Customer>>();
		try {			
				response = customerService.getAllCustomers(first,rows,globalFilter,sortOrder);
				//response.setData(customers);
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(response.getData().size()+" Records Matched.");
				}
				else {
					response = new Response<List<Customer>>();
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
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Customer>>> responseEntity = new ResponseEntity<Response<List<Customer>>>(response,HttpStatus.OK);				
		return responseEntity;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Customer>> getCustomerById(@PathVariable String id) {	
		String METHOD_NAME = "getCustomerById";
		Response<Customer> response = new Response<Customer>();
		try {			
				Customer customer = customerService.getCustomerById(id);
				response.setData(customer);
				if(customer != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Customer by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Customer Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<Response<Customer>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/phone/{phone}", method = RequestMethod.GET)
	public ResponseEntity<Response<Customer>> getCustomerByPhone(@PathVariable String phone) {
		String METHOD_NAME = "getCustomerByPhone";
		Response<Customer> response = new Response<Customer>();
		try {
				Customer customer = customerService.getCustomerByPhone(phone);

				if(customer != null) {
					response.setData(customer);
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Customer by Phone request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Customer Record Found for Phone '"+phone+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<Response<Customer>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Customer>> create(@RequestBody Customer customer) {
		String METHOD_NAME = "create";
		Response<Customer> response =  new Response<Customer>();
		try {
				Customer existing = customerService.getCustomerByPhone(customer.getPhone());
				if(existing == null) {
					Customer savedCustomer = customerService.addCustomer(customer);
				    response.setData(savedCustomer);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("New Customer Record is Created.");
				}
				else {
					response.setStatusCode("-1");
				    response.setMessage(Response.FAILED);
				    response.setSuccessful(false);
				    response.setMessageDetail("ERROR: Customer with this phone number already exist.");
				}    
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<Response<Customer>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Customer>> update(@RequestBody Customer customer) {
		String METHOD_NAME = "update";
		Response<Customer> response =  new Response<Customer>();
		try {
			    Customer savedCustomer = customerService.updateCustomer(customer);
			    response.setData(savedCustomer);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Customer Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<Response<Customer>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = customerService.deleteCustomer(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Customer Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}
}
