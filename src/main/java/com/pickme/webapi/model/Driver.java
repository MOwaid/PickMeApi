package com.pickme.webapi.model;

import com.pickme.webapi.document.Vehicle;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;



public class Driver {
	private String id;
	private String firstName;
	private String lastName;
	private String AKA;
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
	private String devicePhone;
	private String status;
	private Date lastActive;
	private Date lastBooking;
	private String driverType;
	private String lati;
	private String longi;
	
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

	public void setAKA(String AKA) {
		this.AKA = AKA;
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

	public Date getLastBooking() {
		return lastBooking;
	}

	public void setLastBooking(Date lastBooking) {
		this.lastBooking = lastBooking;
	}

	public String getDriverType() {
		return driverType;
	}

	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}
	
	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}
	
	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}
	
}
