package com.pickme.webapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.common.Util;
import com.pickme.webapi.document.HttpUserSession;
import com.pickme.webapi.repo.mongo.HttpUserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pickme.webapi.document.Driver;
import com.pickme.webapi.repo.mongo.DriverRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class DriverService {

	@Autowired DriverRepository driverRepo;
	@Autowired LogRepository logRepo;
	@Autowired
    HttpUserSessionRepository httpUserSessionRepository;

	@Value("${driverTokenExpirationTimeMint}")
    private String expirationTimeMint;
	
	public List<Driver> search(String parameters) {
		return null;
	}
	public List<Driver> getAllDrivers() {
		List<Driver> drivers = driverRepo.findByDeleted(false);
		return drivers;
	}
	public Driver getDriverById(String id) {
		Optional<Driver> driver = driverRepo.findById(id);
		return driver.get();
	}
	public Driver findDriverById(String id) {
		return null;
	}
	public Driver addDriver(Driver driver) {
		driver.setStatus(ApplicationConstants.STATUS_ACTIVE);
		Driver newDriver = driverRepo.insert(driver);
		return newDriver;
	}
	public Driver updateDriver(Driver driver) {
		Driver newDriver = driverRepo.save(driver);
		return newDriver;
	}
	public boolean deleteDriver(String id) {
		return driverRepo.deleteDriver(id);	
	}
	public HttpUserSession validate(com.pickme.webapi.model.Driver driver){
		Driver dbDriver = driverRepo.findByLoginIdAndPasswordAndDeleted(driver.getLoginId(),driver.getPassword(),false);
		if(dbDriver!=null){
            String token = Util.generateToken();
            Date tokenExpiry  = Util.generateTokenExpiry(Integer.parseInt(expirationTimeMint));
            HttpUserSession httpUserSession = getHttpUserSession(dbDriver);
			httpUserSession.setToken(token);
			httpUserSession.setTokenExpiry(tokenExpiry);
            HttpUserSession dbHttpUserSession = httpUserSessionRepository.insert(httpUserSession);
            return dbHttpUserSession;
		}
		return null;
	}

	private HttpUserSession getHttpUserSession(Driver dbDriver) {
		HttpUserSession httpUserSession = new HttpUserSession();
		httpUserSession.setUserId(dbDriver.getLoginId());
		httpUserSession.setUserDbId(dbDriver.getId());
		httpUserSession.setUserName(dbDriver.getLastName());
		httpUserSession.setCreatedAt(new Date());
		httpUserSession.setCreatedBy(dbDriver.getLastName());
		return httpUserSession;
	}

	public List<Driver> getDriverByStatus(String status) {
		List<Driver> drivers = driverRepo.findByStatusAndDeleted(status,false);
		return drivers;
	}
}