package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.DriverPrivilege;
import com.pickme.webapi.repo.mongo.custom.DriverPrivilegeCustomRepository;

public interface DriverPrivilegeRepository extends MongoRepository<DriverPrivilege, String>,DriverPrivilegeCustomRepository {
	public List<DriverPrivilege> findByDriverId(String driverID);
	public List<DriverPrivilege> findByCreatedBy(String createdBy);
	public List<DriverPrivilege> findByUpdatedBy(String updatedBy);
	public List<DriverPrivilege> findByDeleted(boolean deleted);
	Page<DriverPrivilege> findByDeleted(boolean deleted, Pageable pageable);

}
