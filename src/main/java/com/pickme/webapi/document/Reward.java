package com.pickme.webapi.document;
//import java.text.DecimalFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="rewards")
public class Reward {
	@Id
	private String id; 
	private boolean recurringReward;
	private Integer rewardsCounter; // If Recurring is false, then Counter cannot exceed 1
	//private DecimalFormat rewardAmount;
	//private DecimalFormat rewardPercentage; //Either Amount or Percent should be defined
	private String rewardAmount;
	private String rewardPercentage; //Either Amount or Percent should be defined
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
	public boolean isRecurringReward() {
		return recurringReward;
	}
	public void setRecurringReward(boolean recurringReward) {
		this.recurringReward = recurringReward;
	}

	public Integer getRewardsCounter() {
		return rewardsCounter;
	}
	public void setRewardsCounter(Integer rewardsCounter) {
		this.rewardsCounter = rewardsCounter;
	}
	public String getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(String rewardAmount) {
		this.rewardAmount = rewardAmount;
	}
	public String getRewardPercentage() {
		return rewardPercentage;
	}
	public void setRewardPercentage(String rewardPercentage) {
		this.rewardPercentage = rewardPercentage;
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
