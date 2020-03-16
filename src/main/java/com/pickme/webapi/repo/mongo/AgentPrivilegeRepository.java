package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.AgentPrivilege;
import com.pickme.webapi.document.Reward;
import com.pickme.webapi.document.Job;
import com.pickme.webapi.repo.mongo.custom.AgentPrivilegeCustomRepository;

public interface AgentPrivilegeRepository extends MongoRepository<AgentPrivilege, String>,AgentPrivilegeCustomRepository {
	public List<AgentPrivilege> findByAllowRejectJob(boolean allowRejectJob);
	//public List<AgentPrivilege> findByRewardId(Reward reward); //inner document
	public List<AgentPrivilege> findByShowFare(boolean showFare);
	//public List<AgentPrivilege> findByJobId(Job job); // inner document
	public List<AgentPrivilege> findByCreatedBy(String createdBy);
	public List<AgentPrivilege> findByUpdatedBy(String updatedBy);
	public List<AgentPrivilege> findByDeleted(boolean deleted);
	Page<AgentPrivilege> findByDeleted(boolean deleted, Pageable pageable);

}
