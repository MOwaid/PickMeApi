package com.pickme.webapi.model;

import java.util.Date;

public class PaymentOptions {
	private String paymentDay;
	private String paymentType;
	private Date lastPayment;
	private String distribution;
	private boolean applyVAT;
	private Double VATRate;
	private Double balance;
	private boolean excludeBooking;
	private Double commission;
	private String paymentCard;
	private Date paymentCardExpiry;
	private boolean bankPayment;
	private boolean useSPEA;
	private String bankName;
	private String accountName;
	private String sortCode;
	private String accountNumber;
	public String getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Date getLastPayment() {
		return lastPayment;
	}
	public void setLastPayment(Date lastPayment) {
		this.lastPayment = lastPayment;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public boolean isApplyVAT() {
		return applyVAT;
	}
	public void setApplyVAT(boolean applyVAT) {
		this.applyVAT = applyVAT;
	}
	public Double getVATRate() {
		return VATRate;
	}
	public void setVATRate(Double vATRate) {
		VATRate = vATRate;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public boolean isExcludeBooking() {
		return excludeBooking;
	}
	public void setExcludeBooking(boolean excludeBooking) {
		this.excludeBooking = excludeBooking;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	public String getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(String paymentCard) {
		this.paymentCard = paymentCard;
	}
	public Date getPaymentCardExpiry() {
		return paymentCardExpiry;
	}
	public void setPaymentCardExpiry(Date paymentCardExpiry) {
		this.paymentCardExpiry = paymentCardExpiry;
	}
	public boolean isBankPayment() {
		return bankPayment;
	}
	public void setBankPayment(boolean bankPayment) {
		this.bankPayment = bankPayment;
	}
	public boolean isUseSPEA() {
		return useSPEA;
	}
	public void setUseSPEA(boolean useSPEA) {
		this.useSPEA = useSPEA;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}	
}
