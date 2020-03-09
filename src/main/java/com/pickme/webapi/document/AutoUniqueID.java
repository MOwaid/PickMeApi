package com.pickme.webapi.document;

import org.springframework.data.annotation.Id;

public class AutoUniqueID {
	
	@Id
	private String id;
	private String Prefix;
	private Integer count;
	public String getPrefix() {
		return Prefix;
	}
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	} 

}
