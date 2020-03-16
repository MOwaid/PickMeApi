package com.pickme.webapi.document;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.pickme.webapi.model.Address;

@Document(collection="fares")

public class Fare {
	@Id
	private String id; 
	private String dayFare;
	private String nightFare;
	private String waitFare;
	private String specialFee;
	private String specialDiscount;
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
	public String getDayFare() {
		return dayFare;
	}
	public void setDayFare(String dayFare) {
		this.dayFare = dayFare;
	}
	public String getNightFare() {
		return nightFare;
	}
	public void setNightFare(String nightFare) {
		this.nightFare = nightFare;
	}
	public String getWaitFare() {
		return waitFare;
	}
	public void setWaitFare(String waitFare) {
		this.waitFare = waitFare;
	}
	public String getSpecialFee() {
		return specialFee;
	}
	public void setSpecialFee(String specialFee) {
		this.specialFee = specialFee;
	}
	public String getSpecialDiscount() {
		return specialDiscount;
	}
	public void setSpecialDiscount(String specialDiscount) {
		this.specialDiscount = specialDiscount;
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
