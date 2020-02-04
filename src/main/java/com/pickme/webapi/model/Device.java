package com.pickme.webapi.model;

public class Device {

	private String IMEI;
	private boolean locked;
	private String deviceOS;
	private boolean phoneAssist;
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getDeviceOS() {
		return deviceOS;
	}
	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}
	public boolean isPhoneAssist() {
		return phoneAssist;
	}
	public void setPhoneAssist(boolean phoneAssist) {
		this.phoneAssist = phoneAssist;
	}
	
}
