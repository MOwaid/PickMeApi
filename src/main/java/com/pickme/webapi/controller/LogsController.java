package com.pickme.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.webapi.document.Log;
import com.pickme.webapi.services.LogsService;

@RestController
@RequestMapping("/logs")
@CrossOrigin
public class LogsController {

	/** Inject LogsService class instance Automatically by Spring Framework **/
	@Autowired LogsService logsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Log>> getAllLogs(
			@RequestParam(value = "first", required = false) int first,
		    @RequestParam(value = "rows", required = false) int rows,
		    @RequestParam(value = "sortOrder", required = false) String sortOrder,
		    @RequestParam(value = "sortOrder", required = false) String sortBy,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters)  {
	    
		return null;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Log> getLogById(@PathVariable String id) {
	    return null;
	}
	@RequestMapping(value = "/action/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Log>> getLogByAction(@PathVariable String id) {
	    return null;
	}
	@RequestMapping(value = "/createdBy/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Log>> getLogByCreatedBy(@PathVariable String id) {
	    return null;
	}
	
}
