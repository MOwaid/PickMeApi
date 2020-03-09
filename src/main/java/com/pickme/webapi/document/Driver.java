package com.pickme.webapi.document;

import java.util.Date;
import java.util.Map;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pickme.webapi.model.Address;
import com.pickme.webapi.model.Device;
import com.pickme.webapi.model.DrivingLicense;
import com.pickme.webapi.model.InvoiceOptions;
import com.pickme.webapi.model.PaymentOptions;

@Document(collection="drivers")
public class Driver {
	@org.springframework.data.annotation.Id
	private String id;
	private String photo;
	private String firstName;
	private String lastName;
	private String AKA;
	private Address address;
	private String email;
	private String mobilePhone;
	private String otherPhone;
	private String sex;
	private String ethnicity;
	private String paymentCard;
	private Date cardExpiryDate;
	private String loginId;
	private String password;
	private String siid;
	private Vehicle vehicle;
	private String devicePhone;
	private String status;
	private Date lastActive;
	private Date lastBooking;
	private String driverType;
	private DrivingLicense driverLicense;
	private Map<String,Boolean> driverAttributes;
	private String notes;
	private Device device;
	private InvoiceOptions invoiceOptions;
	private PaymentOptions paymentOptions;
	private Map<String,String> driverDocuments;
	private boolean deleted;
	private Date createdAt;
	private String createdBy;
	private Date lastUpdated;
	private String updatedBy;
	private String latitude;
	private String longitude;
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public Driver(){
	}
	public Driver(String id){
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getAKA() {
		return AKA;
	}
	public void setAKA(String aKA) {
		AKA = aKA;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getOtherPhone() {
		return otherPhone;
	}
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(String paymentCard) {
		this.paymentCard = paymentCard;
	}
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getDevicePhone() {
		return devicePhone;
	}
	public void setDevicePhone(String devicePhone) {
		this.devicePhone = devicePhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLastActive() {
		return lastActive;
	}
	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}
	public String getDriverType() {
		return driverType;
	}
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}
	public DrivingLicense getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(DrivingLicense driverLicense) {
		this.driverLicense = driverLicense;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public InvoiceOptions getInvoiceOptions() {
		return invoiceOptions;
	}
	public void setInvoiceOptions(InvoiceOptions invoiceOptions) {
		this.invoiceOptions = invoiceOptions;
	}
	public PaymentOptions getPaymentOptions() {
		return paymentOptions;
	}
	public void setPaymentOptions(PaymentOptions paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	public Map<String, String> getDriverDocuments() {
		return driverDocuments;
	}
	public void setDriverDocuments(Map<String, String> driverDocuments) {
		this.driverDocuments = driverDocuments;
	}
	public Map<String, Boolean> getDriverAttributes() {
		return driverAttributes;
	}
	public void setDriverAttributes(Map<String, Boolean> driverAttributes) {
		this.driverAttributes = driverAttributes;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getLastBooking() {
		return lastBooking;
	}
	public void setLastBooking(Date lastBooking) {
		this.lastBooking = lastBooking;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
	
	public String getlatitude() {
		return this.latitude ;
	}
	public void setlatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getlongitude() {
		return this.longitude ;
	}
	public void setlongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
