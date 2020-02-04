package com.pickme.webapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickme.webapi.document.Log;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class LogsService {

	/** Inject LogRepository class instance Automatically by Spring Framework **/
	@Autowired LogRepository logRepo;
	
	public void create(Log log) {
		logRepo.save(log);
	}
	public List<Log> findAll() {
		return logRepo.findAll();
	}
	public Log findLogById(String id) {
		Optional<Log> opLog = logRepo.findById(id);
		return opLog.get();
	}
	public List<Log> findLogByModule(String module) {
		return logRepo.findByModule(module);
	}
	public List<Log> findLogTask(String className) {
		return logRepo.findByClassName(className);
	}
	
	public List<Log> findLogByCreatedBy(String createdBy) {
		return logRepo.findByCreatedBy(createdBy);
	}
}
