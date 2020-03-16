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
import com.pickme.webapi.document.DriverPrivilege;
import com.pickme.webapi.services.DriverPrivilegeService;

@RestController
@RequestMapping("/driverPrivilege")
@CrossOrigin
public class DriverPrivilegeController {
	
	@Autowired DriverPrivilegeService driverPrivilegeService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<DriverPrivilege>>> getAllDriverPrivileges(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllDriverPrivileges";
		Response<List<DriverPrivilege>> response = new Response<List<DriverPrivilege>>();
		try {			
				List<DriverPrivilege> driverprivileges = driverPrivilegeService.getAllDriverPrivileges(); 
				response.setData(driverprivileges);
				if(driverprivileges != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(driverprivileges.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, DriverPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<DriverPrivilege>>> responseEntity = new ResponseEntity<Response<List<DriverPrivilege>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<DriverPrivilege>> getDriverPrivilegeById(@PathVariable String id) {	
		String METHOD_NAME = "getDriverPrivilegeById";
		Response<DriverPrivilege> response = new Response<DriverPrivilege>();
		try {			
			DriverPrivilege driverprivilege = driverPrivilegeService.getDriverPrivilegeById(id);
			response.setData(driverprivilege);
			if(driverprivilege != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Driver Privilege by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Driver Privilege Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, DriverPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<DriverPrivilege>> responseEntity = new ResponseEntity<Response<DriverPrivilege>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{driverID}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<DriverPrivilege>>> getDriverPrivilegeByDriverID(@PathVariable String driverID) {	
		String METHOD_NAME = "getDriverPrivilegeByDriverID";
		Response<List<DriverPrivilege>> response = new Response<List<DriverPrivilege>>();
		try {			
				List<DriverPrivilege> driverprivileges = driverPrivilegeService.getDriverPrivilegeByDriverId(driverID);
				response.setData(driverprivileges);
				if(driverprivileges != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Driver Privilege by Driver ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Driver Privilege Record Found for ID '"+driverID+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, DriverPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<DriverPrivilege>>> responseEntity = new ResponseEntity<Response<List<DriverPrivilege>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<DriverPrivilege>> update(@RequestBody DriverPrivilege driverprivilege) {
		String METHOD_NAME = "update";
		Response<DriverPrivilege> response =  new Response<DriverPrivilege>();
		try {
			DriverPrivilege savedDriverPrivilege = driverPrivilegeService.updateDriverPrivilege(driverprivilege);
			response.setData(savedDriverPrivilege);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Driver Privilege Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, DriverPrivilegeController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<DriverPrivilege>> responseEntity = new ResponseEntity<Response<DriverPrivilege>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = driverPrivilegeService.deleteDriverPrivilege(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Driver Privilege Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, DriverPrivilegeController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}