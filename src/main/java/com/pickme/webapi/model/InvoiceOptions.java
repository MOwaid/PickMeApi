package com.pickme.webapi.model;

public class InvoiceOptions {

	private boolean invoiced;
	private String paymentTerms;
	private String outputPref;
	private String invoiceFooter;
	public boolean isInvoiced() {
		return invoiced;
	}
	public void setInvoiced(boolean invoiced) {
		this.invoiced = invoiced;
	}
	public String getPaymentTerms() {
		return paymentTerms;
	}
	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public String getOutputPref() {
		return outputPref;
	}
	public void setOutputPref(String outputPref) {
		this.outputPref = outputPref;
	}
	public String getInvoiceFooter() {
		return invoiceFooter;
	}
	public void setInvoiceFooter(String invoiceFooter) {
		this.invoiceFooter = invoiceFooter;
	}
	
}
