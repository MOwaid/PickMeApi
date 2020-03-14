package com.pickme.webapi.document;

//import java.text.DecimalFormat;
import java.util.Date;

import org.apache.tomcat.jni.Time;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="job_details")
public class Job {
	@Id
	private String id; 
	private String startTime;
	private String endTime;
	//private DecimalFormat maxJobsAllowed;
	private String maxJobsAllowed;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMaxJobsAllowed() {
		return maxJobsAllowed;
	}
	public void setMaxJobsAllowed(String maxJobsAllowed) {
		this.maxJobsAllowed = maxJobsAllowed;
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
