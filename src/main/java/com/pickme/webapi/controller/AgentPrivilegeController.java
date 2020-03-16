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
import com.pickme.webapi.document.AgentPrivilege;
import com.pickme.webapi.document.Bank;
import com.pickme.webapi.services.AgentPrivilegeService;

@RestController
@RequestMapping("/agentPrivilege")
@CrossOrigin
public class AgentPrivilegeController {
	
	@Autowired AgentPrivilegeService agentPrivilegeService;
	@Autowired Logger LOGGER;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<AgentPrivilege>>> getAllAgentPrivileges(
			@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllAgentPrivileges";
		Response<List<AgentPrivilege>> response = new Response<List<AgentPrivilege>>();
		try {			
				List<AgentPrivilege> agentprivileges = agentPrivilegeService.getAllAgentPrivileges(); 
				response.setData(agentprivileges);
				if(agentprivileges != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setMessageDetail(agentprivileges.size()+" Records Matched.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<AgentPrivilege>>> responseEntity = new ResponseEntity<Response<List<AgentPrivilege>>>(response,HttpStatus.OK);				
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<AgentPrivilege>> getAgentPrivilegeById(@PathVariable String id) {	
		String METHOD_NAME = "getAgentPrivilegeById";
		Response<AgentPrivilege> response = new Response<AgentPrivilege>();
		try {			
			AgentPrivilege agentprivilege = agentPrivilegeService.getAgentPrivilegeById(id);
			response.setData(agentprivilege);
			if(agentprivilege != null) {			
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Get Agent Privilege by ID request was Successful.");			
			}
			else {
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("No Agent Privilege Record Found for ID '"+id+"'");
			}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<AgentPrivilege>> responseEntity = new ResponseEntity<Response<AgentPrivilege>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/{allowRejectJob}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<AgentPrivilege>>> getAgentPrivilegesByAllowRejectJob(@PathVariable boolean allowRejectJob) {	
		String METHOD_NAME = "getAgentPrivilegesByAllowRejectJob";
		Response<List<AgentPrivilege>> response = new Response<List<AgentPrivilege>>();
		try {			
				List<AgentPrivilege> agentprivileges = agentPrivilegeService.getAgentPrivilegeByAllowRejectJob(allowRejectJob);
				response.setData(agentprivileges);
				if(agentprivileges != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Agent Privilege by Allow Reject Job request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Agent Privilege Record Found for Option Allow Reject Job '"+allowRejectJob+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<AgentPrivilege>>> responseEntity = new ResponseEntity<Response<List<AgentPrivilege>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}

	/*
	 * @RequestMapping(value = "/reward/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<Response<List<AgentPrivilege>>>
	 * getAgentPrivilegesByRewardID(@PathVariable String id) { String METHOD_NAME =
	 * "getAgentPrivilegesByRewardID"; Response<List<AgentPrivilege>> response = new
	 * Response<List<AgentPrivilege>>(); try { List<AgentPrivilege> agentprivileges
	 * = agentPrivilegeService.getAgentPrivilegeByRewardID(id);
	 * response.setData(agentprivileges); if(agentprivileges != null) {
	 * response.setStatusCode("0"); response.setMessage(Response.SUCCESSFUL);
	 * response.setSuccessful(true); response.
	 * setMessageDetail("Get Agent Privilege by Rewards ID request was Successful."
	 * ); } else { response.setStatusCode("0");
	 * response.setMessage(Response.SUCCESSFUL); response.setSuccessful(true);
	 * response.setMessageDetail("No Agent Privilege Record Found for Reward ID '"
	 * +id+"'"); } } catch(Exception e) { response.setStatusCode("-1");
	 * response.setMessage(Response.FAILED); response.setSuccessful(false);
	 * response.setMessageDetail(e.getMessage());
	 * LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES,
	 * AgentPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(),
	 * ApplicationConstants.APPLICATION_NAME); }
	 * ResponseEntity<Response<List<AgentPrivilege>>> responseEntity = new
	 * ResponseEntity<Response<List<AgentPrivilege>>>(response,HttpStatus.OK);
	 * return responseEntity; }
	 */
	@RequestMapping(value = "/{showFare}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<AgentPrivilege>>> getAgentPrivilegesByShowFare(@PathVariable boolean showFare) {	
		String METHOD_NAME = "getAgentPrivilegesByShowFare";
		Response<List<AgentPrivilege>> response = new Response<List<AgentPrivilege>>();
		try {			
				List<AgentPrivilege> agentprivileges = agentPrivilegeService.getAgentPrivilegeByShowFare(showFare);
				response.setData(agentprivileges);
				if(agentprivileges != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Agent Privilege by Show Fare request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Agent Privilege Record Found for Option Show Fare '"+showFare+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<AgentPrivilege>>> responseEntity = new ResponseEntity<Response<List<AgentPrivilege>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}

	/*
	 * @RequestMapping(value = "/job/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<Response<List<AgentPrivilege>>>
	 * getAgentPrivilegesByJobID(@PathVariable String id) { String METHOD_NAME =
	 * "getAgentPrivilegesByJobID"; Response<List<AgentPrivilege>> response = new
	 * Response<List<AgentPrivilege>>(); try { List<AgentPrivilege> agentprivileges
	 * = agentPrivilegeService.getAgentPrivilegeByJobID(id);
	 * response.setData(agentprivileges); if(agentprivileges != null) {
	 * response.setStatusCode("0"); response.setMessage(Response.SUCCESSFUL);
	 * response.setSuccessful(true); response.
	 * setMessageDetail("Get Agent Privilege by Job ID request was Successful."); }
	 * else { response.setStatusCode("0"); response.setMessage(Response.SUCCESSFUL);
	 * response.setSuccessful(true);
	 * response.setMessageDetail("No Agent Privilege Record Found for Job ID '"+id+
	 * "'"); } } catch(Exception e) { response.setStatusCode("-1");
	 * response.setMessage(Response.FAILED); response.setSuccessful(false);
	 * response.setMessageDetail(e.getMessage());
	 * LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES,
	 * AgentPrivilegeController.class.getName(), METHOD_NAME, e.getMessage(),
	 * ApplicationConstants.APPLICATION_NAME); }
	 * ResponseEntity<Response<List<AgentPrivilege>>> responseEntity = new
	 * ResponseEntity<Response<List<AgentPrivilege>>>(response,HttpStatus.OK);
	 * return responseEntity; }
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<AgentPrivilege>> create(@RequestBody AgentPrivilege agentprivilege) {
		String METHOD_NAME = "create";
		Response<AgentPrivilege> response =  new Response<AgentPrivilege>();
		try {
			//AgentPrivilege existing = agentPrivilegeService.getAgentPrivilegeByShowFare(agentprivilege.isShowFare()); 
			String existing = null;
			if(existing == null) {
				AgentPrivilege newAgentPrivilege = agentPrivilegeService.addAgentPrivilege(agentprivilege);
			    response.setData(newAgentPrivilege);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New Agent Privilege Record is Created.");
			}
			else {
				response.setStatusCode("-1");
			    response.setMessage(Response.FAILED);
			    response.setSuccessful(false);
			    response.setMessageDetail("ERROR: Agent Privilege already exist.");
			}    
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<AgentPrivilege>> responseEntity = new ResponseEntity<Response<AgentPrivilege>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<AgentPrivilege>> update(@RequestBody AgentPrivilege agentprivilege) {
		String METHOD_NAME = "update";
		Response<AgentPrivilege> response =  new Response<AgentPrivilege>();
		try {
			AgentPrivilege savedAgentPrivilege = agentPrivilegeService.updateAgentPrivilege(agentprivilege);
			response.setData(savedAgentPrivilege);
			response.setStatusCode("0");
			response.setMessage(Response.SUCCESSFUL);
			response.setSuccessful(true);
			response.setMessageDetail("Agent Privilege Record has been successfully Updated.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<AgentPrivilege>> responseEntity = new ResponseEntity<Response<AgentPrivilege>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = agentPrivilegeService.deleteAgentPrivilege(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Agent Privilege Record has been deleted.");
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
			LOGGER.error(ApplicationConstants.MODULE_DRIVER_PRIVILEGES, AgentPrivilegeController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

}