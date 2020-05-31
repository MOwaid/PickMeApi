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
	private String DateFormat;
	private String TimeFormat;
	private String Extra1;
	private String Extra2;
	private String Extra3;
	private String Accountlabel;
	private int BookedTabFromHour;
	private int BookedTabToHour;
	private String BookingRefNumber;
	private int CompletedTabFromHour;
	private int CancelledTabFromHour;
	private int DispatchAppTimmer;
	private int DispatchServerTimmer;
	private int Moneydecimalplace;
	private String BaseCountry;
	private String BaseCity;
	
	
	
	
	
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
	public String getDateFormat() {
		return DateFormat;
	}
	public void setDateFormat(String dateFormat) {
		DateFormat = dateFormat;
	}
	public String getTimeFormat() {
		return TimeFormat;
	}
	public void setTimeFormat(String timeFormat) {
		TimeFormat = timeFormat;
	}
	public String getExtra1() {
		return Extra1;
	}
	public void setExtra1(String extra1) {
		Extra1 = extra1;
	}
	public String getExtra2() {
		return Extra2;
	}
	public void setExtra2(String extra2) {
		Extra2 = extra2;
	}
	public String getExtra3() {
		return Extra3;
	}
	public void setExtra3(String extra3) {
		Extra3 = extra3;
	}
	public String getAccountlabel() {
		return Accountlabel;
	}
	public void setAccountlabel(String accountlabel) {
		Accountlabel = accountlabel;
	}
	public int getBookedTabFromHour() {
		return BookedTabFromHour;
	}
	public void setBookedTabFromHour(int bookedTabFromHour) {
		BookedTabFromHour = bookedTabFromHour;
	}
	public int getCompletedTabFromHour() {
		return CompletedTabFromHour;
	}
	public void setCompletedTabFromHour(int completedTabFromHour) {
		CompletedTabFromHour = completedTabFromHour;
	}
	public int getCancelledTabFromHour() {
		return CancelledTabFromHour;
	}
	public void setCancelledTabFromHour(int cancelledTabFromHour) {
		CancelledTabFromHour = cancelledTabFromHour;
	}
	public int getDispatchAppTimmer() {
		return DispatchAppTimmer;
	}
	public void setDispatchAppTimmer(int dispatchAppTimmer) {
		DispatchAppTimmer = dispatchAppTimmer;
	}
	public int getDispatchServerTimmer() {
		return DispatchServerTimmer;
	}
	public void setDispatchServerTimmer(int dispatchServerTimmer) {
		DispatchServerTimmer = dispatchServerTimmer;
	}
	public int getMoneydecimalplace() {
		return Moneydecimalplace;
	}
	public void setMoneydecimalplace(int moneydecimalplace) {
		Moneydecimalplace = moneydecimalplace;
	}
	public int getBookedTabToHour() {
		return BookedTabToHour;
	}
	public void setBookedTabToHour(int bookedTabToHour) {
		BookedTabToHour = bookedTabToHour;
	}
	public String getBookingRefNumber() {
		return BookingRefNumber;
	}
	public void setBookingRefNumber(String bookingRefNumber) {
		BookingRefNumber = bookingRefNumber;
	}
	public String getBaseCountry() {
		return BaseCountry;
	}
	public void setBaseCountry(String baseCountry) {
		BaseCountry = baseCountry;
	}
	public String getBaseCity() {
		return BaseCity;
	}
	public void setBaseCity(String baseCity) {
		BaseCity = baseCity;
	}
	
}
