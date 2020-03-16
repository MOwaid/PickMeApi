package com.pickme.webapi.controller;
import java.util.List;

import org.apache.tomcat.jni.Time;
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
import com.pickme.webapi.document.Job;
import com.pickme.webapi.services.JobService;

@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobController {
	
	@Autowired JobService jobService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Job>>> getAllJobs(
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllJobs";
		Response<List<Job>> response = new Response<List<Job>>();
		try {			
				List<Job> jobs = jobService.getAllJobs(); 
				response.setData(jobs);
				if(jobs != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(jobs.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Job>>> responseEntity = new ResponseEntity<Response<List<Job>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Job>> getJobById(@PathVariable String id) {	
		String METHOD_NAME = "getJobById";
		Response<Job> response = new Response<Job>();
		try {			
			Job job = jobService.getJobById(id);
			response.setData(job);
			if(job != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Job by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Job Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Job>> responseEntity = new ResponseEntity<Response<Job>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{startTime}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Job>>> getJobsByStartTime(@PathVariable String startTime) {	
		String METHOD_NAME = "getJobsByStartTime";
		Response<List<Job>> response = new Response<List<Job>>();
		try {			
				List<Job> jobs = jobService.getJobByStartTime(startTime);
				response.setData(jobs);
				if(jobs != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Jobs by Start Time request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Job Record Found for Start Time '"+startTime+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Job>>> responseEntity = new ResponseEntity<Response<List<Job>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{endTime}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Job>>> getJobsByEndTime(@PathVariable String endTime) {	
		String METHOD_NAME = "getJobsByEndTime";
		Response<List<Job>> response = new Response<List<Job>>();
		try {			
				List<Job> jobs = jobService.getJobByEndTime(endTime);
				response.setData(jobs);
				if(jobs != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Jobs by End Time request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Job Record Found for End Time '"+endTime+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Job>>> responseEntity = new ResponseEntity<Response<List<Job>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}	
	@RequestMapping(value = "/{maxAllowedJobs}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Job>>> getJobsByMaxAllowedJobs(@PathVariable String maxAllowedJobs) {	
		String METHOD_NAME = "getJobsByMaxAllowedJobs";
		Response<List<Job>> response = new Response<List<Job>>();
		try {			
				List<Job> jobs = jobService.getJobByMaxAllowedJobs(maxAllowedJobs);
				response.setData(jobs);
				if(jobs != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Jobs by Max Allowed Jobs request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Max Allowed Jobs Record Found for '"+maxAllowedJobs+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Job>>> responseEntity = new ResponseEntity<Response<List<Job>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Job>> update(@RequestBody Job job) {
		String METHOD_NAME = "update";
		Response<Job> response =  new Response<Job>();
		try {
			Job savedJob = jobService.updateJob(job);
			    response.setData(savedJob);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Job Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Job>> responseEntity = new ResponseEntity<Response<Job>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = jobService.deleteJob(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Job Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, JobController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}
