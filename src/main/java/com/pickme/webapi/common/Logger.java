package com.pickme.webapi.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickme.webapi.document.Log;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class Logger {

	@Autowired
	LogRepository logRepo;

	public static final String ERROR = "Error: ";
	public static final String WARNING = "Warning: ";
	public static final String DEBUG = "debug: ";
	public static final String INFO = "Info: ";
	public static final String GENERIC = "Generic";
	
	public static Date currentTime() {
		return new Date();
	}
	
	public  void error(String module, String className, String methodName, String desc,String createdBy) {
		if(module == null || module == "") {
			module = GENERIC;
		}
		if(className == null || className == "") {
			className = Logger.class.getName();
		}
		if(methodName == null || methodName == "") {
			methodName = ERROR;
		}
		
		Log log = new Log(module,className,methodName,desc, currentTime(),createdBy);
		logRepo.save(log);
	}
	public  void warning(String module, String className, String methodName, String desc, String createdBy) {
		if(module == null || module == "") {
			module = GENERIC;
		}
		if(className == null || className == "") {
			className = Logger.class.getName();
		}
		if(methodName == null || methodName == "") {
			methodName = WARNING;
		}
		Log log = new Log(module,className,methodName,desc, currentTime(),createdBy);
		logRepo.save(log);
	}
	public  void debug(String module, String className, String methodName, String desc, String createdBy) {
		if(module == null || module == "") {
			module = GENERIC;
		}
		if(className == null || className == "") {
			className = Logger.class.getName();
		}
		if(methodName == null || methodName == "") {
			methodName = DEBUG;
		}
		Log log = new Log(module,className,methodName,desc, currentTime(),createdBy);
		logRepo.save(log);
	}
	public  void info(String module, String className, String methodName, String desc, String createdBy) {
		if(module == null || module == "") {
			module = GENERIC;
		}
		if(className == null || className == "") {
			className = Logger.class.getName();
		}
		if(methodName == null || methodName == "") {
			methodName = INFO;
		}
		Log log = new Log(module,className,methodName,desc, currentTime(),createdBy);
		logRepo.save(log);
	}

}
