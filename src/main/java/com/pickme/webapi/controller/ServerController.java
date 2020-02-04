package com.pickme.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.webapi.common.Logger;

@RestController
@RequestMapping("/server")
@CrossOrigin
public class ServerController {

	@Autowired
	Logger logger;
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String serverStatus() {
		logger.info("", ServerController.class.getName(), "serverStatus()", "Server Status Checked!", "admin");
		return "PickMe Cab API Server is Up & Running...";
	}
}
