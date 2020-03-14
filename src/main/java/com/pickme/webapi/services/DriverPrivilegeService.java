package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.DriverPrivilege;
import com.pickme.webapi.repo.mongo.DriverPrivilegeRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class DriverPrivilegeService {

	@Autowired DriverPrivilegeRepository driverPrivilegeRepo;
	@Autowired LogRepository logRepo;
	public List<DriverPrivilege> getAllDriverPrivileges() {
		List<DriverPrivilege> driverprivileges = driverPrivilegeRepo.findByDeleted(false); 
		return driverprivileges;
	}
	
	public DriverPrivilege getDriverPrivilegeById(String id) {
		Optional<DriverPrivilege> driverprivilege = driverPrivilegeRepo.findById(id);
		return driverprivilege.get();
	}
	public List<DriverPrivilege> getDriverPrivilegeByDriverId(String driverID) { //check this
		List<DriverPrivilege> driverprivilege = driverPrivilegeRepo.findByDriverId(driverID);
		return driverprivilege;
	}
	public List<DriverPrivilege>  getDriverPrivilegeByCreatedBy(String createdBy) {
		List<DriverPrivilege> driverprivilege=  driverPrivilegeRepo.findByCreatedBy(createdBy);
		return driverprivilege;
	}
	public List<DriverPrivilege>  getDriverPrivilegeByUpdatedBy(String updatedBy) {
		List<DriverPrivilege> driverprivilege=  driverPrivilegeRepo.findByUpdatedBy(updatedBy);
		return driverprivilege;
	}
	public DriverPrivilege addDriverPrivilege(DriverPrivilege driverprivilege) {
		DriverPrivilege newDriverPrivilege = driverPrivilegeRepo.insert(driverprivilege);
		return newDriverPrivilege;
	}
	public DriverPrivilege updateDriverPrivilege(DriverPrivilege driverprivilege) {
		DriverPrivilege newDriverPrivilege = driverPrivilegeRepo.save(driverprivilege);
		return newDriverPrivilege;
	}
	public boolean deleteDriverPrivilege(String id) {
		return driverPrivilegeRepo.deleteDriverPrivilege(id);
	}
}
