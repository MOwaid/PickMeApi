package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="addresses")
public class Address {

	@Id
	private String id;
	private String buildingNumber;
	private String buildingName;
	private String buildingType;
	private String subBuilding;
	private String company;
	private String department;
	private String shortCode;
	private String accessKey;
	private String driverInstr;
	private String operatorInstr;
	private String street;
	private String streetType;
	private String area;
	private String postCode;
	private String county;
	private String state;
	private Number priority;
	private Number pickLeadTime;
	private Number destLeadTime;
	private Number discount;
	private String comments;
	private boolean isApproved;
	private boolean isUsed;
	private boolean deleted;
	private boolean varified;
	private Date dateCreated;
	private String createdBy;
	private Date lastUpdated;
	private String updatedBy;
	private String completeAddress;
	

	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getSubBuilding() {
		return subBuilding;
	}
	public void setSubBuilding(String subBuilding) {
		this.subBuilding = subBuilding;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	
	public String getDriverInstr() {
		return driverInstr;
	}
	public void setDriverInstr(String driverInstr) {
		this.driverInstr = driverInstr;
	}
	public String getOperatorInstr() {
		return operatorInstr;
	}
	public void setOperatorInstr(String operatorInstr) {
		this.operatorInstr = operatorInstr;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetType() {
		return streetType;
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Number getPriority() {
		return this.priority;
	}
	public void setPriority(Number priority) {
		this.priority = priority;
	}
	public Number getPickLeadTime() {
		return pickLeadTime;
	}
	public void setPickLeadTime(Number pickLeadTime) {
		this.pickLeadTime = pickLeadTime;
	}
	public Number getDestLeadTime() {
		return destLeadTime;
	}
	public void setDestLeadTime(Number destLeadTime) {
		this.destLeadTime = destLeadTime;
	}
	public Number getDiscount() {
		return discount;
	}
	public void setDiscount(Number discount) {
		this.discount = discount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	public boolean isVarified() {
		return varified;
	}
	public void setVarified(boolean varified) {
		this.varified = varified;
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

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}
	
}
