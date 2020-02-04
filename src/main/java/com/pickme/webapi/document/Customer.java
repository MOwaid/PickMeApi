package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pickme.webapi.model.Address;
import com.pickme.webapi.model.AddressSearchModel;
import com.pickme.webapi.model.Priority;

@Document(collection="customers")
public class Customer {
 
 @Id
 private String id;
 private String firstName;
 private String lastName;
 private String phone;
 private String email;
 private String userLogin;
 private String password;
 private AddressSearchModel [] addresses;
 private AddressSearchModel [] pickUpAddresses;
 private AddressSearchModel [] dropUpAddresses;
 private String comments;
 private Priority priority;
 private boolean deleted;
 private Date dateCreated;
 private String createdBy;
 private Date lastUpdated;
 private String updatedBy;
 	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Priority getPriority() {
		return this.priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public AddressSearchModel[] getAddresses() {
		return addresses;
	}
	public void setAddresses(AddressSearchModel[] addresses) {
		this.addresses = addresses;
	}
	public AddressSearchModel[] getPickUpAddresses() {
		return pickUpAddresses;
	}
	public void setPickUpAddresses(AddressSearchModel[] pickUpAddresses) {
		this.pickUpAddresses = pickUpAddresses;
	}
	public AddressSearchModel[] getDropUpAddresses() {
		return dropUpAddresses;
	}
	public void setDropUpAddresses(AddressSearchModel[] dropUpAddresses) {
		this.dropUpAddresses = dropUpAddresses;
	}
	
}
