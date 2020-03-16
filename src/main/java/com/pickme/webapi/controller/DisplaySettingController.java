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
import com.pickme.webapi.document.DisplaySetting;
import com.pickme.webapi.services.DisplaySettingService;

@RestController
@RequestMapping("/displaySetting")
@CrossOrigin
public class DisplaySettingController {
	
	@Autowired DisplaySettingService displaySettingService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<DisplaySetting>>> getAllDisplaySettings(
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllDisplaySettings";
		Response<List<DisplaySetting>> response = new Response<List<DisplaySetting>>();
		try {			
				List<DisplaySetting> displaysettings = displaySettingService.getAllDisplaySettings(); 
				response.setData(displaysettings);
				if(displaysettings != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(displaysettings.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_DISPLAY_SETTING, DisplaySettingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<DisplaySetting>>> responseEntity = new ResponseEntity<Response<List<DisplaySetting>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<DisplaySetting>> getDisplaySettingById(@PathVariable String id) {	
		String METHOD_NAME = "getDisplaySettingById";
		Response<DisplaySetting> response = new Response<DisplaySetting>();
		try {			
			DisplaySetting displaysetting = displaySettingService.getDisplaySettingById(id);
			response.setData(displaysetting);
			if(displaysetting != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Display Setting by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Display Setting Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DISPLAY_SETTING, DisplaySettingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<DisplaySetting>> responseEntity = new ResponseEntity<Response<DisplaySetting>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{allowMapView}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<DisplaySetting>>> getDisplaySettingsByAllowMapView(@PathVariable boolean allowMapView) {	
		String METHOD_NAME = "getDisplaySettingsByAllowMapView";
		Response<List<DisplaySetting>> response = new Response<List<DisplaySetting>>();
		try {			
				List<DisplaySetting> displaysettings = displaySettingService.getDisplaySettingByAllowMapView(allowMapView);
				response.setData(displaysettings);
				if(displaysettings != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Display Setting by Allow Map View request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Display Setting Record found for option Allow Map View '"+allowMapView+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DISPLAY_SETTING, DisplaySettingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<DisplaySetting>>> responseEntity = new ResponseEntity<Response<List<DisplaySetting>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{displayUnit}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<DisplaySetting>>> getDisplaySettingsByDisplayUnit(@PathVariable String displayUnit) {	
		String METHOD_NAME = "getDisplaySettingsByDisplayUnit";
		Response<List<DisplaySetting>> response = new Response<List<DisplaySetting>>();
		try {			
				List<DisplaySetting> displaysettings = displaySettingService.getDisplaySettingByDisplayUnits(displayUnit);
				response.setData(displaysettings);
				if(displaysettings != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Display Setting by Display Unit request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Display Setting Record Found for Display Unit '"+displayUnit+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DISPLAY_SETTING, DisplaySettingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<DisplaySetting>>> responseEntity = new ResponseEntity<Response<List<DisplaySetting>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<DisplaySetting>> update(@RequestBody DisplaySetting displaysetting) {
		String METHOD_NAME = "update";
		Response<DisplaySetting> response =  new Response<DisplaySetting>();
		try {
			DisplaySetting savedDisplaySetting = displaySettingService.updateDisplaySetting(displaysetting);
			response.setData(savedDisplaySetting);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Display Setting Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DISPLAY_SETTING, DisplaySettingController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<DisplaySetting>> responseEntity = new ResponseEntity<Response<DisplaySetting>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = displaySettingService.deleteDisplaySetting(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Display Setting Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_DISPLAY_SETTING, DisplaySettingController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
