package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Reward;
import com.pickme.webapi.document.AgentPrivilege;
import com.pickme.webapi.document.Job;
import com.pickme.webapi.repo.mongo.AgentPrivilegeRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class AgentPrivilegeService {

	@Autowired AgentPrivilegeRepository agentPrivilegeRepo;
	@Autowired LogRepository logRepo;
	public List<AgentPrivilege> getAllAgentPrivileges() {
		List<AgentPrivilege> agentprivileges = agentPrivilegeRepo.findByDeleted(false); 
		return agentprivileges;
	}
	
	public AgentPrivilege getAgentPrivilegeById(String id) {
		Optional<AgentPrivilege> agentprivilege = agentPrivilegeRepo.findById(id);
		return agentprivilege.get();
	}
	public List<AgentPrivilege> getAgentPrivilegeByAllowRejectJob(boolean allowRejectJob) {
		List<AgentPrivilege> agentprivileges = agentPrivilegeRepo.findByAllowRejectJob(allowRejectJob);
		return agentprivileges;
	}

	/*
	 * public List<AgentPrivilege> getAgentPrivilegeByRewardID(Reward reward) {
	 * List<AgentPrivilege> agentprivileges =
	 * agentPrivilegeRepo.findByRewardId(reward); return agentprivileges; }
	 */
	public List<AgentPrivilege> getAgentPrivilegeByShowFare(boolean showFare) {
		List<AgentPrivilege> agentprivileges = agentPrivilegeRepo.findByShowFare(showFare);
		return agentprivileges;
	}

	/*
	 * public List<AgentPrivilege> getAgentPrivilegeByJobID(Job job) {
	 * List<AgentPrivilege> agentprivileges = agentPrivilegeRepo.findByJobId(job);
	 * return agentprivileges; }
	 */
	public List<AgentPrivilege>  getAgentPrivilegeByCreatedBy(String createdBy) {
		List<AgentPrivilege> agentprivileges=  agentPrivilegeRepo.findByCreatedBy(createdBy);
		return agentprivileges;
	}
	public List<AgentPrivilege>  getAgentPrivilegeByUpdatesBy(String updatedBy) {
		List<AgentPrivilege> agentprivileges=  agentPrivilegeRepo.findByUpdatedBy(updatedBy);
		return agentprivileges;
	}
	public AgentPrivilege addAgentPrivilege(AgentPrivilege agentprivilege) {
		AgentPrivilege newAgentPrivilege = agentPrivilegeRepo.insert(agentprivilege);
		return newAgentPrivilege;
	}
	public AgentPrivilege updateAgentPrivilege(AgentPrivilege agentprivilege) {
		AgentPrivilege newAgentPrivilege = agentPrivilegeRepo.save(agentprivilege);
		return newAgentPrivilege;
	}
	public boolean deleteAgentPrivilege(String id) {
		return agentPrivilegeRepo.deleteAgentPrivilege(id);
	}
}
