package com.pickme.webapi.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection="recurring")
public class Recurring {
	@Id
	private String id; 

	String isRecurring;
	String recurringMode;
	String[] recurringWeekdays;
	Date recurringEndDate;
	String recurringEndMonth="1";
	
	
	public String getisRecurring() {
		return isRecurring;
	}
	public void setisRecurring(String isRecurring) {
		this.isRecurring = isRecurring;
	}
	
	public String getrecurringMode() {
		return recurringMode;
	}
	public void setrecurringMode(String recurringMode) {
		this.recurringMode = recurringMode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public Date getrecurringEndDate() {
		return recurringEndDate;
	}
	public void setrecurringEndDate(Date recurringEndDate) {
		this.recurringEndDate = recurringEndDate;
	}
	
	
	
	public String getrecurringEndMonth() {
		return recurringEndMonth;
	}
	public void setrecurringEndMonth(String recurringEndMonth) {
		this.id = recurringEndMonth;
	}
	
	
	public String[] getrecurringWeekdays() {
		return recurringWeekdays;
	}
	public void setrecurringWeekdays(String[] recurringWeekdays) {
		this.recurringWeekdays = recurringWeekdays;
	}
	
}
