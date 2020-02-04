package com.pickme.webapi.controller;

import java.util.ArrayList;
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

import com.pickme.webapi.document.User;
import com.pickme.webapi.services.UserService;



@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired UserService userService;
	@Autowired Logger LOGGER;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "first", required = false) String first,
		    @RequestParam(value = "rows", required = false) String rows,
		    @RequestParam(value = "sortOrder", required = false) String action,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		
		List<User> users = new ArrayList<User>();
		
		
		ResponseEntity<List<User>> response = new ResponseEntity<>(users,HttpStatus.OK);
		return response;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable String id,
											@RequestBody User user) {
		return null;
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<User>> create(@RequestBody User user) {
		
		System.out.println("YAY-----------"+user.getFirstName());
		System.out.println("YAY-----------"+user.getLastName());
		System.out.println("YAY-----------"+user.getUserName());
		System.out.println("YAY-----------"+user.getPhone());
		System.out.println("YAY-----------"+user.getPassword());
	
		String METHOD_NAME = "create";
		Response<User> response =  new Response<User>();
		try {
			User savedUser = userService.addUser(user);
			    response.setData(savedUser);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("New User Record is Created.");
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, UserController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);		    
		}
		ResponseEntity<Response<User>> responseEntity = new ResponseEntity<Response<User>>(response,HttpStatus.OK);
		return responseEntity;
		
	}
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<Response<User>> authenticate(@RequestBody User user) {
		String METHOD_NAME = "findByuserNameAndpasswordAndDeleted";
		Response<User> response = new Response<User>();
		try {			
			User dbuser = userService.findUserByuserName(user);
				response.setData(dbuser);
				if(dbuser != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get User by UserName request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No User Record Found for UserName '"+ user.getUserName()+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_DRIVER, UserController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<User>> responseEntity = new ResponseEntity<Response<User>>(response,HttpStatus.OK);				
		return responseEntity;		
		 
		}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<User> logout(@RequestBody User user) {
		return null;
	}
	@RequestMapping(value = "/logout/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> logoutWithId(@PathVariable String id) {
		return null;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
		return null;
	}
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@RequestBody User user) {
		return null;
	}
}
