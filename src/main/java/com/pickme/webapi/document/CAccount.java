package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="caccounts")
public class CAccount {

	@Id
	private String id; 
	private String title;
	private String companyName; 
	private String type; 
	private Address companyAddress; 
	private String accountNumber;  
	private String notes;  
	private String status; 
	private Date openingDate;
	private String approvedBy; 
	private Number openingBalance;
	private Number closingBalance;
	private Number currentBalance;
	private Date dateCreated;
	private String createdBy; 
	private Date lastUpdated;
	private String updatedBy; 
	private boolean deleted;
	private Address address; 
    
    private String companyPhoneNumber;
    private String contactName;
    private String contactPhoneNumber;
    private String serviceChargePrec;
    private Number discountPrec;
    private boolean isActive;
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Address getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Number getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Number openingBalance) {
		this.openingBalance = openingBalance;
	}
	public Number getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(Number closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Number getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Number currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}
	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getServiceChargePrec() {
		return serviceChargePrec;
	}
	public void setServiceChargePrec(String serviceChargePrec) {
		this.serviceChargePrec = serviceChargePrec;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public Number getDiscountPrec() {
		return discountPrec;
	}
	public void setDiscountPrec(Number discountPrec) {
		this.discountPrec = discountPrec;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
