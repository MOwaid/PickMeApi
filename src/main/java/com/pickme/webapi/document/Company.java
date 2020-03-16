package com.pickme.webapi.document;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.gridfs.GridFS;


@Document(collection="companies")
public class Company {
	@Id
	private String id; 

	private String companyName;
	private String companyShortName;
	private String companyCode;
	private GridFS companyLogo;
	//private CompanyType companyType;
	private String companyType;
	private String businessRegistrationNumber;
	private String fbrRegistrationNumber;
	private String NTN;
	private String salesTaxRegistrationNumber;
	private Account[] accountsDetailsList;
	private Owner[] ownersDetailsList;
	private Address addressDetails;
	private Configuration companyConfigurations;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyShortName() {
		return companyShortName;
	}
	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public GridFS getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(GridFS companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getBusinessRegistrationNumber() {
		return businessRegistrationNumber;
	}
	public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
		this.businessRegistrationNumber = businessRegistrationNumber;
	}
	public String getFbrRegistrationNumber() {
		return fbrRegistrationNumber;
	}
	public void setFbrRegistrationNumber(String fbrRegistrationNumber) {
		this.fbrRegistrationNumber = fbrRegistrationNumber;
	}
	public String getNTN() {
		return NTN;
	}
	public void setNTN(String nTN) {
		this.NTN = nTN;
	}
	public String getSalesTaxRegistrationNumber() {
		return salesTaxRegistrationNumber;
	}
	public void setSalesTaxRegistrationNumber(String salesTaxRegistrationNumber) {
		this.salesTaxRegistrationNumber = salesTaxRegistrationNumber;
	}
	public Account[] getAccountsDetailsList() {
		return accountsDetailsList;
	}
	public void setAccountsDetailsList(Account[] accountsDetailsList) {
		this.accountsDetailsList = accountsDetailsList;
	}
	public Owner[] getOwnersDetailsList() {
		return ownersDetailsList;
	}
	public void setOwnersDetailsList(Owner[] ownersDetailsList) {
		this.ownersDetailsList = ownersDetailsList;
	}
	public Address getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(Address addressDetails) {
		this.addressDetails = addressDetails;
	}
	public Configuration getCompanyConfigurations() {
		return companyConfigurations;
	}
	public void setCompanyConfigurations(Configuration companyConfigurations) {
		this.companyConfigurations = companyConfigurations;
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
