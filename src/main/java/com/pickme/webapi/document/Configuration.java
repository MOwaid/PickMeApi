package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="configurations")
public class Configuration {
	@Id
	private String id; 
	
	private String[] notificationTypes; //Values from NOTIFICATION_TYPES (COMMON DATA)
	private boolean alertPreference; // Company wants alerts or not
	private Currency currency;
	private String timeZone;
	private DriverPrivilege[] driverPrivilegesList;
	private String fareScopeLevel; // Values from FARE_SCOPE_LEVELS (COMMON DATA)
	private Fare fareDetails;
	private DisplaySetting displaySettings;
	private String language; // Values from LANGUAGES (COMMON DATA)
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
	public String[] getNotificationTypes() {
		return notificationTypes;
	}
	public void setNotificationTypes(String[] notificationTypes) {
		this.notificationTypes = notificationTypes;
	}
	public boolean isAlertPreference() {
		return alertPreference;
	}
	public void setAlertPreference(boolean alertPreference) {
		this.alertPreference = alertPreference;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public DriverPrivilege[] getDriverPrivilegesList() {
		return driverPrivilegesList;
	}
	public void setDriverPrivilegesList(DriverPrivilege[] driverPrivilegesList) {
		this.driverPrivilegesList = driverPrivilegesList;
	}
	public String getFareScopeLevel() {
		return fareScopeLevel;
	}
	public void setFareScopeLevel(String fareScopeLevel) {
		this.fareScopeLevel = fareScopeLevel;
	}
	public Fare getFareDetails() {
		return fareDetails;
	}
	public void setFareDetails(Fare fareDetails) {
		this.fareDetails = fareDetails;
	}
	public DisplaySetting getDisplaySettings() {
		return displaySettings;
	}
	public void setDisplaySettings(DisplaySetting displaySettings) {
		this.displaySettings = displaySettings;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
