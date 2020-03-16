package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Configuration;
import com.pickme.webapi.repo.mongo.ConfigurationRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class ConfigurationService {

	@Autowired ConfigurationRepository configurationRepo;
	@Autowired LogRepository logRepo;
	public List<Configuration> getAllConfigurations() {
		List<Configuration> configuration = configurationRepo.findByDeleted(false); 
		return configuration;
	}
	
	public Configuration getConfigurationById(String id) {
		Optional<Configuration> configuration = configurationRepo.findById(id);
		return configuration.get();
	}
	public List<Configuration>  getConfigurationByTimeZone(String timeZone) {
		List<Configuration> configurations = configurationRepo.findByTimeZone(timeZone);
		return configurations;
	}
	public List<Configuration>  getConfigurationByCreatedBy(String createdBy) {
		List<Configuration> configurations =  configurationRepo.findByCreatedBy(createdBy);
		return configurations;
	}
	public List<Configuration>  getConfigurationByUpdatedBy(String updatedBy) {
		List<Configuration> configurations=  configurationRepo.findByUpdatedBy(updatedBy);
		return configurations;
	}
	public Configuration addConfiguration(Configuration configuration) {
		Configuration newConfiguration = configurationRepo.insert(configuration);
		return newConfiguration;
	}
	public Configuration updateConfiguration(Configuration configuration) {
		Configuration newConfiguration = configurationRepo.save(configuration);
		return newConfiguration;
	}
	public boolean deleteConfiguration(String id) {
		return configurationRepo.deleteConfiguration(id);
	}
}
