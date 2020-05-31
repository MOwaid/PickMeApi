package com.pickme.webapi.services;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.List;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.services.CustomerService;
import com.pickme.webapi.model.AssignDto;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.AutoUniqueID;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.repo.mongo.BookingRepository;
import com.pickme.webapi.repo.mongo.LogRepository;
import com.pickme.webapi.services.AndroidPushNotificationsService;

@Service
public class BookingService {
	@Autowired BookingRepository bookingRepo;
	@Autowired AndroidPushNotificationsService androidPushNotificationsService;
	@Autowired LogRepository logRepo;
	@Autowired AutoUniqueIDService autoIdservice;
	@Autowired CustomerService custService;
	public Response<List<Booking>> getAllBookings(Integer first,Integer rows, String globalFilter,String sortOrder) {
		Response<List<Booking>> response = new Response<List<Booking>>();
		if(first != null & rows != null) {
			if(first > 0) {
				rows+=first;
			}
			
			
			if (globalFilter != null)
			{
					if(globalFilter.compareTo("1")  == 0)
					{
					
					  LocalDate today = LocalDate.now();
					  LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
					  LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
					//  Date = getZeroTimeDate(today.getChronology().dateNow());
					  
				/*	  List<Article> result = repository.findAllWithCreationDateTimeBefore(
					          new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00"));
					 
					  */
					  
		 			  List<Booking> pageResult =bookingRepo.findAllBystartTimeBetween(yesterday,tomorrow);
					  long totalRecords = pageResult.size();// getTotalElements();
					  response.setData(pageResult);// .getContent());
					  response.setTotalRecords(totalRecords);
					}
			}
			else
			{
				 Page<Booking> pageResult =bookingRepo.findAll(PageRequest.of(first, rows,Sort.by("id").descending()));
				 long totalRecords = pageResult.getTotalElements();
				 response.setData(pageResult.getContent());
				 response.setTotalRecords(totalRecords);
			}
			
			
			
			
		}
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Booking getBookingById(String id) {
		Optional<Booking> booking = bookingRepo.findById(id);
		return booking != null ? booking.get() : null;
	}
	public Response<List<Booking>> getBookingsByStatus(String status,Integer first,Integer rows, String globalFilter,String sortOrder) {
		
		Response<List<Booking>> response = new Response<List<Booking>>();
		if(status != null) {
			status = status.toUpperCase();
		}
		/*iif(first != null & rows != null) {
			if(first > 0) {
				rows+=first;
			}
			Page<Booking> pageResult = bookingRepo.findByStatus(status,PageRequest.of(first, rows));
			long totalRecords = pageResult.getTotalElements();
			response.setData(pageResult.getContent());
			response.setTotalRecords(totalRecords);
		}*/
		response.setData( bookingRepo.findByStatus(status));
		return response;
	}
	
	public Response<List<Booking>> getBookingsByDriverId(String driverId,Date fromDate,Date toDate) {
		
		Response<List<Booking>> response = new Response<List<Booking>>();
		
		
	
		if(fromDate != null && toDate !=null)
		{
		List<Booking> bookingList = bookingRepo.findByDriverIdAndstartTime(driverId,convertToLocalDateViaInstant(fromDate),convertToLocalDateViaInstant(toDate));
		response.setData(bookingList);
		}
		else {		
		
		List<Booking> bookingList = bookingRepo.findByDriverId(driverId);
		response.setData(bookingList);
		}
		/*List<Booking> bookingList = bookingRepo.searchByDriverIdAndDate(driverId);*/
			
		
		return response;
	}
	
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
public Response<List<Booking>> getBookingsByCustomerId(String CustomerId,Date fromDate,Date toDate) {
		
		Response<List<Booking>> response = new Response<List<Booking>>();
		
		
		/*List<Booking> bookingList = bookingRepo.findByDriverIdAndDate(driverId,fromDate,toDate);*/
		if(fromDate != null && toDate !=null)
		{
		List<Booking> bookingList = bookingRepo.findByCustomerIdAndstartTime(CustomerId,convertToLocalDateViaInstant(fromDate),convertToLocalDateViaInstant(toDate));
		response.setData(bookingList);
		}
		else
		{
			List<Booking> bookingList = bookingRepo.findByCustomerId(CustomerId);
			response.setData(bookingList);
		}
		/*List<Booking> bookingList = bookingRepo.searchByDriverIdAndDate(driverId);*/
	
			
		
		return response;
	}
		
	
	
	
public Response<List<Booking>> getBookingsByDriverIdstartTimeSorted(String driverId) {
		
		Response<List<Booking>> response = new Response<List<Booking>>();
		

		
		
		  
		  LocalDate today = LocalDate.now();
		  LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		/*  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
		  String text = today.format(formatter);
		  String text1 = tomorrow.format(formatter);
		  LocalDate strDate = LocalDate.parse(text, formatter);
		  
		  LocalDate mytomorrow = LocalDate.parse(text1, formatter);;*/
		
		
		
		
		/*List<Booking> bookingList = bookingRepo.findByDriverIdAndDate(driverId,fromDate,toDate);*/
		  
		List<Booking> bookingList = bookingRepo.getObjectBystartTimeAndDriverId(today, tomorrow, driverId);
		/*List<Booking> bookingList = bookingRepo.searchByDriverIdAndDate(driverId);*/
			
		response.setData(bookingList);
		return response;
	}
	
	
	
	
	
	public boolean deleteBooking(String id) {
		return true;
	}
	public Booking create(Booking bookingObj) {
		/*Booking booking = bookingRepo.findByIdAndDriver(bookingObj.getId(),bookingObj.getDriver());
		if(booking!=null){
			booking.setStatus(ApplicationConstants.STATUS_DELETE);
			return bookingRepo.insert(booking);
		}else{
			return null;
		}*/
		
		AutoUniqueID ID = new AutoUniqueID();
		ID.setCount(0);
		ID.setPrefix("BK");
		ID = autoIdservice.GetNewRef(ID);
		
		NumberFormat nf = new DecimalFormat("00000");
		
		LocalDate today = LocalDate.now();
		String prefix = String.format("%02d",today.getMonthValue());
		prefix = prefix + Calendar.getInstance().get(Calendar.YEAR) % 100;
		
		prefix = prefix + nf.format(ID.getCount());
		
		
		bookingObj.setPrefixID(ID.getPrefix()+prefix);
		
		
		
		setStatus(bookingObj);
		return bookingRepo.insert(bookingObj);
	}
	public Booking updateBooking(Booking booking) {
		String id  = booking.getId();
		String newStatus = booking.getStatus();
		
		Optional<Booking> updateBookingOptional = bookingRepo.findById(id);
		Booking updatedBoking = updateBookingOptional.get();
		if(updateBookingOptional==null && updatedBoking==null )
			return null;
		updatedBoking.setStatus(booking.getStatus());
		updatedBoking = booking;

		return bookingRepo.save(updatedBoking);
	}
	
	public String pushNotificationToTopic(String topic, String driverID, String bookingID, String DriverName)
	{
		//----Push Notification
		JSONObject body = new JSONObject();
	

		String firebaseResponse="";
	
			if( topic != null)
			{
			body.put("to", "/topics/" + topic );
	
			}
		
	    body.put("priority", "high");
	    //body.put("android_channel_id", "pickmecab_updates");
	
	    
	    JSONObject notification = new JSONObject();
	    notification.put("body",DriverName + " a new Job has been assigned to you.");
	    notification.put("title","You get a new job Mr. " + DriverName);
	   
	    body.put("notification", notification);
	/*    JSONObject data = new JSONObject();
	    data.put("title", "Job Creation Notification");
	    data.put("body", "New job has been created and assigned to you");
	  //  data.put("message", "New Job");
	   // data.put("click_action","new_ride");
	    data.put("driver-id", driverID);
	    data.put("booking-id", bookingID);
	 
	   	    
	   
	    	
	    	
	        body.put("data", data);*/
	   
	 
	/**
	    {
	       
	       "data": {
	        "title": "JSA Notification",
	          "body": "Happy Message!"
	          "Key-1": "JSA Data 1",
	          "Key-2": "JSA Data 2"
	       },
	       "to": "/topics/JavaSampleApproach",
	       "priority": "high"
	    }
	*/
	 
	    HttpEntity<String> request = new HttpEntity<>(body.toString());
	  
	 
	   CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
	   CompletableFuture.allOf(pushNotification).join();
	 
	    try {
	   firebaseResponse = pushNotification.get();
	      
	      
	      return ("New Booking Record is Created."+firebaseResponse);
	     
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	      return firebaseResponse;
	    } catch (ExecutionException e) {
	      e.printStackTrace();
	      return firebaseResponse;
	    }
	 
}

	public String pushDataToTopic(String topic, String driverID, String bookingID, String DriverName)
	{
		//----Push Notification
		JSONObject body = new JSONObject();
		

		String firebaseResponse="";
	
			if( topic != null)
			{
			body.put("to", "/topics/" + topic );
		
			}
		
	    body.put("priority", "high");
	    //body.put("android_channel_id", "pickmecab_updates");
	    
	    
	   /* JSONObject notification = new JSONObject();
	    notification.put("body",DriverName + " a new Job has been assigned to you.");
	    notification.put("title","You get a new job Mr. " + DriverName);
	   
	    body.put("notification", notification);*/
	    JSONObject data = new JSONObject();
	    data.put("title", "Job Creation Notification");
	    data.put("body", "New job has been created and assigned to you");
	  //  data.put("message", "New Job");
	   // data.put("click_action","new_ride");
	    data.put("driver-id", driverID);
	    data.put("booking-id", bookingID);
	 
	   	    
	   
	    	
	    	
	        body.put("data", data);
	   
	 
	/**
	    {
	       
	       "data": {
	        "title": "JSA Notification",
	          "body": "Happy Message!"
	          "Key-1": "JSA Data 1",
	          "Key-2": "JSA Data 2"
	       },
	       "to": "/topics/JavaSampleApproach",
	       "priority": "high"
	    }
	*/
	 
	    HttpEntity<String> request = new HttpEntity<>(body.toString());
	 
	 
	  CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
	  CompletableFuture.allOf(pushNotification).join();
	
	 try {
	     firebaseResponse = pushNotification.get();
	        
	      return ("New Booking Record is Created."+firebaseResponse);
	     
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	      return firebaseResponse;
	    } catch (ExecutionException e) {
	      e.printStackTrace();
	      return firebaseResponse;
	    }
	 
}
	

	public Booking updateBookingStatus(Booking bookingObj) {
		Optional<Booking> bookingOptional = bookingRepo.findById(bookingObj.getId());
		if(bookingOptional ==null || bookingOptional.get()==null)
			return null;
		Booking dbBooking = bookingOptional.get();
		if(dbBooking!=null){
			dbBooking.setStatus(bookingObj.getStatus());
			return bookingRepo.save(dbBooking);
		}else{
			return null;
		}
	}

	public void setStatus(Booking booking) {
		Driver driver = booking.getDriver();
		Date currentDate = getZeroTimeDate(new Date());
		Date bookingStartDate = getZeroTimeDate(booking.getStartTime());
		if(driver==null || driver.getId()==null){
			if(currentDate.compareTo(bookingStartDate)==0){
				booking.setStatus(ApplicationConstants.BOOKING_STATUS_BOOKED);
			}else if(bookingStartDate.after(currentDate)){
				booking.setStatus(ApplicationConstants.BOOKING_STATUS_BOOKED);
			}

		}else{
			//if(currentDate.compareTo(bookingStartDate)==0)
				//booking.setStatus(ApplicationConstants.BOOKING_STATUS_ALLOCATED); //uncommit if you want to allocate driver at the time of job creation
				booking.setStatus(ApplicationConstants.BOOKING_STATUS_BOOKED);
		}
		


	}
	private static Date getZeroTimeDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}

	public Booking accept(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;
		String status = booking.getStatus();

		 if (status == ApplicationConstants.BOOKING_STATUS_BOOKED || status == ApplicationConstants.BOOKING_STATUS_DELETED || status == ApplicationConstants.BOOKING_STATUS_CANCELLED )
	        {
        	return booking;
        }
        else
        {
		booking.setStatus(ApplicationConstants.BOOKING_STATUS_CONFIRMED);
		return bookingRepo.save(booking);
        }
	}

	public Booking complete(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_COMPLETED);
		return bookingRepo.save(booking);
	}
	
	public Booking inprogress(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_INPROGRESS);
		return bookingRepo.save(booking);
	}
	
	public Booking dispatch(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_DISPATCH);
		return bookingRepo.save(booking);
	}
	
	
	public Booking onhold(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_ONHOLD);
		return bookingRepo.save(booking);
	}
	
	
	
	public Booking booked(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;
		if(booking.getDriver()!=null)
		{
			booking.setStatus(ApplicationConstants.BOOKING_STATUS_ALLOCATED);
		}
		else
		{

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_BOOKED);
		}
		return bookingRepo.save(booking);
	}
	
	
	public Booking cancelled(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_CANCELLED);
		return bookingRepo.save(booking);
	}
	
	public Booking reject(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;
		
		String status = booking.getStatus();

		 if (status == ApplicationConstants.BOOKING_STATUS_BOOKED || status == ApplicationConstants.BOOKING_STATUS_DELETED || status == ApplicationConstants.BOOKING_STATUS_CANCELLED )
	        {
	        	return booking;
	        }
	        else
	        {
				booking.setStatus(ApplicationConstants.BOOKING_STATUS_REJECTED);
				
				return bookingRepo.save(booking);
	        }
	}

	public Booking assign(AssignDto assignDto) {

		Optional<Booking> optional = bookingRepo.findById(assignDto.getBookingId());
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		//booking.setStatus(ApplicationConstants.BOOKING_STATUS_BOOKED);
		booking.setDriver(new Driver(assignDto.getDriverId()));
		booking.setStatus(ApplicationConstants.BOOKING_STATUS_ALLOCATED);
		return bookingRepo.save(booking);

	}
}
