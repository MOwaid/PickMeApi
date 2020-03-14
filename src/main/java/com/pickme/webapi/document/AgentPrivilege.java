package com.pickme.webapi.document;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="agent_privileges")
public class AgentPrivilege {
	@Id
	private String id; 
	private boolean allowRejectJob;
	private boolean showFare;
	private Reward rewardDetails;
	private Job jobDetails;
	private String comments;
	private boolean deleted;
	private Date dateCreated;
	private String createdBy;
	private Date lastUpdated;
	private String updatedBy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isAllowRejectJob() {
		return allowRejectJob;
	}
	public void setAllowRejectJob(boolean allowRejectJob) {
		this.allowRejectJob = allowRejectJob;
	}
	public boolean isShowFare() {
		return showFare;
	}
	public void setShowFare(boolean showFare) {
		this.showFare = showFare;
	}
	
	public Reward getRewardDetails() {
		return rewardDetails;
	}
	public void setRewardDetails(Reward rewardDetails) {
		this.rewardDetails = rewardDetails;
	}
	public Job getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(Job jobDetails) {
		this.jobDetails = jobDetails;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
