package com.pickme.webapi.controller;

import java.util.Date;
import java.util.List;

import com.pickme.webapi.common.Util;
import com.pickme.webapi.document.HttpUserSession;
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
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.services.DriverService;

@RestController
@RequestMapping("/drivers")
@CrossOrigin
public class DriverController {

	@Autowired DriverService driverService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Driver>>> getAllDrivers(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllDrivers";
		Response<List<Driver>> response = new Response<List<Driver>>();
		try {			
				List<Driver> drivers = driverService.getAllDrivers();
				response.setData(drivers);
				if(drivers != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(drivers.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, DriverController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Driver>>> responseEntity = new ResponseEntity<Response<List<Driver>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Driver>>> getAllDriversByStatus(@PathVariable String status,
																		@RequestParam(value = "first", required = false) String first,
																@RequestParam(value = "rows", required = false) String rows,
																@RequestParam(value = "sortOrder", required = false) String action,
																@RequestParam(value = "globalFilter", required = false) String globalFilter,
																@RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllDriversByStatus";
		Response<List<Driver>> response = new Response<List<Driver>>();
		try {
			List<Driver> drivers = driverService.getDriverByStatus(status);

			if(drivers != null && drivers.size()>0) {
				response.setData(drivers);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail(drivers.size()+" Records Matched.");
			}
			else {
				response.setData(drivers);
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, DriverController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<List<Driver>>> responseEntity = new ResponseEntity<Response<List<Driver>>>(response,HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Driver>> getDriverById(@PathVariable String id) {
		String METHOD_NAME = "getDriverById";
		Response<Driver> response = new Response<Driver>();
		try {			
				Driver Driver = driverService.getDriverById(id);
				response.setData(Driver);
				if(Driver != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Driver by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Driver Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, DriverController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Driver>> responseEntity = new ResponseEntity<Response<Driver>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Driver>> create(@RequestBody Driver driver) {
		String METHOD_NAME = "create";
		Response<Driver> response =  new Response<Driver>();
		try {
			    Driver savedDriver = driverService.addDriver(driver);
			    response.setData(savedDriver);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Driver Record is Created.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, DriverController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<Driver>> responseEntity = new ResponseEntity<Response<Driver>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Driver>> update(@RequestBody Driver driver) {
		String METHOD_NAME = "update";
		Response<Driver> response =  new Response<Driver>();
		try {
			    Driver savedDriver = driverService.updateDriver(driver);
			    response.setData(savedDriver);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Driver Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, DriverController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Driver>> responseEntity = new ResponseEntity<Response<Driver>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@RequestBody String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = driverService.deleteDriver(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Driver Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_CUSTOMER, DriverController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/auth" , method = RequestMethod.POST)
	public ResponseEntity<Response<HttpUserSession>> validate(@RequestBody com.pickme.webapi.model.Driver driver){
		String METHOD_NAME = "validate";
		Response<HttpUserSession> response = new Response<HttpUserSession>();
		try{
            HttpUserSession httpUserSession = driverService.validate(driver);

			if (httpUserSession == null) {
				response.setData(httpUserSession);
				response.setStatusCode("0");
				response.setMessage(Response.FAILED);
				response.setSuccessful(false);
				response.setMessageDetail("Invalid Credentials");
			}else{
				response.setData(httpUserSession);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Driver is validated.");
			}


		}catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, DriverController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<HttpUserSession>> responseEntity = new ResponseEntity<Response<HttpUserSession>>(response,HttpStatus.OK);
		return responseEntity;
	}
}
