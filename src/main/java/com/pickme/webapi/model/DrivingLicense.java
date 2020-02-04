package com.pickme.webapi.model;

import java.util.Date;

public class DrivingLicense {

	private Date issueDate;
	private Date expiryDate;
	private String badge;
	private Date badgeExpiry;
	private String badgeType;
	private String driverLicenseNu;
	private Date schoolBadgeExpiry;
	private String niNumber;
	private String pvgDisclosureDi;
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public Date getBadgeExpiry() {
		return badgeExpiry;
	}
	public void setBadgeExpiry(Date badgeExpiry) {
		this.badgeExpiry = badgeExpiry;
	}
	public String getBadgeType() {
		return badgeType;
	}
	public void setBadgeType(String badgeType) {
		this.badgeType = badgeType;
	}
	public String getDriverLicenseNu() {
		return driverLicenseNu;
	}
	public void setDriverLicenseNu(String driverLicenseNu) {
		this.driverLicenseNu = driverLicenseNu;
	}
	public Date getSchoolBadgeExpiry() {
		return schoolBadgeExpiry;
	}
	public void setSchoolBadgeExpiry(Date schoolBadgeExpiry) {
		this.schoolBadgeExpiry = schoolBadgeExpiry;
	}
	public String getNiNumber() {
		return niNumber;
	}
	public void setNiNumber(String niNumber) {
		this.niNumber = niNumber;
	}
	public String getPvgDisclosureDi() {
		return pvgDisclosureDi;
	}
	public void setPvgDisclosureDi(String pvgDisclosureDi) {
		this.pvgDisclosureDi = pvgDisclosureDi;
	}
	
}
