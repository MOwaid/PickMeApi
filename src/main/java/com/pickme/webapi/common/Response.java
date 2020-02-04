package com.pickme.webapi.common;

public class Response<T> {

	public static final String SUCCESSFUL = "Successful";
	public static final String FAILED = "Failed";
	
	private T data;
	private String statusCode;
	private String message;
	private String messageDetail;
	private boolean successful;
	private long totalRecords;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMessageDetail() {
		return messageDetail;
	}
	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}
}
