package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="logs")
public class HttpUserSession {
	@Id
	private String id;
	private String userId;
	private String userDbId;
	private String userName;
	private String token;
	private Date tokenExpiry;
	private Date createdAt;
	private String createdBy;
	private String deviceId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getTokenExpiry() {
		return tokenExpiry;
	}
	public void setTokenExpiry(Date tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
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

	public String getUserDbId() {
		return userDbId;
	}

	public void setUserDbId(String userDbId) {
		this.userDbId = userDbId;
	}



}
