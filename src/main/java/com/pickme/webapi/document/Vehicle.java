package com.pickme.webapi.document;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
public class Vehicle {
	 @Id
	 private String id;
	 private String vehicleRef;
	 private String vehicleAKA;
	 private String vehicleMake;
	 private String vehicleModel;
	 private String vehicleBodyColour;
	 private int yearOfReg;
	 private String regPlate;
	 private String plateNumber;
	 private Date plateExpiry;
	 private String vehiclePhone;
	 private String vehicleInsurer;
	 private String vehicleInsurPolicyNumber;
	 private Date insuranceExpiry;
	 private String motRef;
	 private Date motExpiry;
	 private Date roadTaxExpiry;
	 private Date councilCompliance;
	 private Date vehicleStart;
	 private Date hireExpiry;
	 private boolean ownerDriver;
	 private Driver vehicleOwner;
	 private String deviceIMEI;
	 private String lightControl;
	 private String statusControl;
	 private boolean sensorsVerifeye;
	 private boolean dataResubmit;
	 private Map<String, Boolean> vehicleAttributes;
	 private boolean deleted;
	 
	 public String getId() {
		return id;
	}
	public String getVehicleRef() {
		return vehicleRef;
	}
	public void setVehicleRef(String vehicleRef) {
		this.vehicleRef = vehicleRef;
	}
	public String getVehicleAKA() {
		return vehicleAKA;
	}
	public void setVehicleAKA(String vehicleAKA) {
		this.vehicleAKA = vehicleAKA;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleBodyColour() {
		return vehicleBodyColour;
	}
	public void setVehicleBodyColour(String vehicleBodyColour) {
		this.vehicleBodyColour = vehicleBodyColour;
	}
	public int getYearOfReg() {
		return yearOfReg;
	}
	public void setYearOfReg(int yearOfReg) {
		this.yearOfReg = yearOfReg;
	}
	public String getRegPlate() {
		return regPlate;
	}
	public void setRegPlate(String regPlate) {
		this.regPlate = regPlate;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public Date getPlateExpiry() {
		return plateExpiry;
	}
	public void setPlateExpiry(Date plateExpiry) {
		this.plateExpiry = plateExpiry;
	}
	public String getVehiclePhone() {
		return vehiclePhone;
	}
	public void setVehiclePhone(String vehiclePhone) {
		this.vehiclePhone = vehiclePhone;
	}
	public String getVehicleInsurer() {
		return vehicleInsurer;
	}
	public void setVehicleInsurer(String vehicleInsurer) {
		this.vehicleInsurer = vehicleInsurer;
	}
	public String getVehicleInsurPolicyNumber() {
		return vehicleInsurPolicyNumber;
	}
	public void setVehicleInsurPolicyNumber(String vehicleInsurPolicyNumber) {
		this.vehicleInsurPolicyNumber = vehicleInsurPolicyNumber;
	}
	public Date getInsuranceExpiry() {
		return insuranceExpiry;
	}
	public void setInsuranceExpiry(Date insuranceExpiry) {
		this.insuranceExpiry = insuranceExpiry;
	}
	public String getMotRef() {
		return motRef;
	}
	public void setMotRef(String motRef) {
		this.motRef = motRef;
	}
	public Date getMotExpiry() {
		return motExpiry;
	}
	public void setMotExpiry(Date motExpiry) {
		this.motExpiry = motExpiry;
	}
	public Date getRoadTaxExpiry() {
		return roadTaxExpiry;
	}
	public void setRoadTaxExpiry(Date roadTaxExpiry) {
		this.roadTaxExpiry = roadTaxExpiry;
	}
	public Date getCouncilCompliance() {
		return councilCompliance;
	}
	public void setCouncilCompliance(Date councilCompliance) {
		this.councilCompliance = councilCompliance;
	}
	public Date getVehicleStart() {
		return vehicleStart;
	}
	public void setVehicleStart(Date vehicleStart) {
		this.vehicleStart = vehicleStart;
	}
	public Date getHireExpiry() {
		return hireExpiry;
	}
	public void setHireExpiry(Date hireExpiry) {
		this.hireExpiry = hireExpiry;
	}
	public boolean isOwnerDriver() {
		return ownerDriver;
	}
	public void setOwnerDriver(boolean ownerDriver) {
		this.ownerDriver = ownerDriver;
	}
	public Driver getVehicleOwner() {
		return vehicleOwner;
	}
	public void setVehicleOwner(Driver vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	public String getDeviceIMEI() {
		return deviceIMEI;
	}
	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}
	public String getLightControl() {
		return lightControl;
	}
	public void setLightControl(String lightControl) {
		this.lightControl = lightControl;
	}
	public String getStatusControl() {
		return statusControl;
	}
	public void setStatusControl(String statusControl) {
		this.statusControl = statusControl;
	}
	public boolean isSensorsVerifeye() {
		return sensorsVerifeye;
	}
	public void setSensorsVerifeye(boolean sensorsVerifeye) {
		this.sensorsVerifeye = sensorsVerifeye;
	}
	public boolean isDataResubmit() {
		return dataResubmit;
	}
	public void setDataResubmit(boolean dataResubmit) {
		this.dataResubmit = dataResubmit;
	}
	public Map<String, Boolean> getVehicleAttributes() {
		return vehicleAttributes;
	}
	public void setVehicleAttributes(Map<String, Boolean> vehicleAttributes) {
		this.vehicleAttributes = vehicleAttributes;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
