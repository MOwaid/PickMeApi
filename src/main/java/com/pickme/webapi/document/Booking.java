package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bookings")
public class Booking {

	@Id
	private String id;
	private String referenceId;
	private String PrefixID;
	private Date startTime;
	private String priority;
	private String linkedJourneyId;
	private String isReturnJourney;
	private String linkedJourneyBKId;
	private String flightNumber;
	
	private Customer customer;
	private Address pickupAddress;
	private Address[] viaAddress;
	private Address destinationAddress;
	private String name;
	private String instructions;
	private Driver driver;
	private String accountNumber;
	private String pin;
	private Integer numberOfPassenger;
	private String taxiNumber;
	private String vi;
	private String extra;
	private String lead;
	private String status;
	private String site;
	private String flightNo;
	private String Price;
	private String drvcomm;
	private String basecomm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReferenceId() {
		return id;
	}
	public void setReferenceId(String id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public Address getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(Address destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Integer getNumberOfPassenger() {
		return numberOfPassenger;
	}
	public void setNumberOfPassenger(Integer numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}
	public String getTaxiNumber() {
		return taxiNumber;
	}
	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}
	public String getVi() {
		return vi;
	}
	public void setVi(String vi) {
		this.vi = vi;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPrefixID() {
		return PrefixID;
	}
	public void setPrefixID(String prefixID) {
		PrefixID = prefixID;
	}

	public String getLinkedJourneyId() {
		return linkedJourneyId;
	}
	public void setLinkedJourneyId(String linkedJourneyId) {
		this.linkedJourneyId = linkedJourneyId;
	}
	public String getIsReturnJourney() {
		return isReturnJourney;
	}
	public void setIsReturnJourney(String isReturnJourney) {
		this.isReturnJourney = isReturnJourney;
	}
	public String getLinkedJourneyBKId() {
		return linkedJourneyBKId;
	}
	public void setLinkedJourneyBKId(String linkedJourneyBKId) {
		this.linkedJourneyBKId = linkedJourneyBKId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Address[] getViaAddress() {
		return viaAddress;
	}
	public void setViaAddress(Address[] viaAddress) {
		this.viaAddress = viaAddress;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getDrvcomm() {
		return drvcomm;
	}
	public void setDrvcomm(String drvcomm) {
		this.drvcomm = drvcomm;
	}
	public String getBasecomm() {
		return basecomm;
	}
	public void setBasecomm(String basecomm) {
		this.basecomm = basecomm;
	}
}
