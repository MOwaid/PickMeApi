package com.pickme.webapi.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="logs")
public class Log {
	@Id
	private String id;
	private String module;
	private String className;
	private String methodName;
	private String description;
	private Date createdAt;
	private String createdBy;
	
	public Log(String module, String className, String methodName, String description, Date createdAt,
			String createdBy) {
		super();
		this.module = module;
		this.className = className;
		this.methodName = methodName;
		this.description = description;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@Override
	public String toString() {
		return "Log [Module= " + module + ", ClassName= " + className + ", MethodName= " + methodName + ", Description= "
				+ description + ", CreatedAt= " + createdAt + "]";
	}
	
	
}
