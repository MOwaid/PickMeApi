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
import com.pickme.webapi.document.Configuration;
import com.pickme.webapi.services.ConfigurationService;

@RestController
@RequestMapping("/configuration")
@CrossOrigin
public class ConfigurationController {
	
	@Autowired ConfigurationService configurationService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Configuration>>> getAllConfigurations(
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllConfigurations";
		Response<List<Configuration>> response = new Response<List<Configuration>>();
		try {			
				List<Configuration> configurations = configurationService.getAllConfigurations(); 
				response.setData(configurations);
				if(configurations != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(configurations.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_CONFIGURATION, ConfigurationController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Configuration>>> responseEntity = new ResponseEntity<Response<List<Configuration>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Configuration>> getConfigurationById(@PathVariable String id) {	
		String METHOD_NAME = "getConfigurationById";
		Response<Configuration> response = new Response<Configuration>();
		try {			
			Configuration configuration = configurationService.getConfigurationById(id);
			response.setData(configuration);
			if(configuration != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Configuration by ID request was Successful.");			
			}
			else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Configuration Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CONFIGURATION, ConfigurationController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Configuration>> responseEntity = new ResponseEntity<Response<Configuration>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
////////////////////////////////////////////////////////////
	@RequestMapping(value = "/{timeZone}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Configuration>>> getConfigurationsByTimeZone(@PathVariable String timeZone) {	
		String METHOD_NAME = "getConfigurationsByTimeZone";
		Response<List<Configuration>> response = new Response<List<Configuration>>();
		try {			
				List<Configuration> configurations = configurationService.getConfigurationByTimeZone(timeZone);
				response.setData(configurations);
				if(configurations != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Configuration by Time Zone request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Configuration Record Found for Time Zone '"+timeZone+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CONFIGURATION, ConfigurationController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Configuration>>> responseEntity = new ResponseEntity<Response<List<Configuration>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
///////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Configuration>> update(@RequestBody Configuration configuration) {
		String METHOD_NAME = "update";
		Response<Configuration> response =  new Response<Configuration>();
		try {
			Configuration savedConfiguration = configurationService.updateConfiguration(configuration);
			    response.setData(savedConfiguration);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Configuration Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_CONFIGURATION, ConfigurationController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Configuration>> responseEntity = new ResponseEntity<Response<Configuration>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = configurationService.deleteConfiguration(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Configuration Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_CONFIGURATION, ConfigurationController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
