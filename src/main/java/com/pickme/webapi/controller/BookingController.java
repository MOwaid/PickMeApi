package com.pickme.webapi.controller;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.List;

import com.pickme.webapi.model.AddressSearchModel;
import com.pickme.webapi.model.AssignDto;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.common.Logger;
import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.services.BookingService;
import com.pickme.webapi.services.CustomerService;
import com.pickme.webapi.services.AddressService;
import com.pickme.webapi.controller.WebSocketController;
import com.pickme.webapi.services.AndroidPushNotificationsService;


@RestController
@RequestMapping("/bookings")
public class BookingController {
	ObjectMapper mapper = new ObjectMapper();
	@Autowired BookingService bookingService;
	@Autowired CustomerService customerService;
	@Autowired AddressService addressService;
	@Autowired WebSocketController webSocket;
	@Autowired Logger LOGGER;
	@Autowired AndroidPushNotificationsService androidPushNotificationsService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Booking>>> getAllBookings(@RequestParam(value = "first", required = false) Integer first,
		    @RequestParam(value = "rows", required = false) Integer rows,
		    @RequestParam(value = "sortField", required = false) String sortOrder,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {
		String METHOD_NAME = "getAllBookings";
		
		Response<List<Booking>> response = new Response<List<Booking>>();
		try {			
				response = bookingService.getAllBookings(first,rows,globalFilter,sortOrder);
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail(response.getData().size()+" Records Matched.");
				}
				else {
					response = new Response<List<Booking>>();
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Record Matched.");
				}
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, BookingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Booking>>> responseEntity = new ResponseEntity<Response<List<Booking>>>(response,HttpStatus.OK);				
		return responseEntity;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Response<Booking>> getBookingById(@PathVariable String id) {	
		String METHOD_NAME = "getBookingById";
		Response<Booking> response = new Response<Booking>();
		try {			
				Booking booking = bookingService.getBookingById(id);
				response.setData(booking);
				if(booking != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Booking by ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Customer Record Found for ID '"+id+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	@RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Booking>>> getBookingByStatus(@PathVariable String status,
			@RequestParam(value = "first", required = false) Integer first,
		    @RequestParam(value = "rows", required = false) Integer rows,
		    @RequestParam(value = "sortField", required = false) String sortOrder,
		    @RequestParam(value = "globalFilter", required = false) String globalFilter,
		    @RequestParam(value = "filters", required = false) String filters) {	
		String METHOD_NAME = "getBookingByStatus";
		Response<List<Booking>> response = new Response<List<Booking>>();
		try {			
				response = bookingService.getBookingsByStatus(status, first, rows, globalFilter, sortOrder);
				//response.setData(booking);
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Booking by Status request was Successful.");			
				}
				else {
					response = new Response<List<Booking>>();
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Booking Record Found for ID '"+status+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Booking>>> responseEntity = new ResponseEntity<Response<List<Booking>>>(response,HttpStatus.OK);					
		return responseEntity;		
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Response<Booking>> create(@RequestBody Booking booking) {
		String METHOD_NAME = "create";
		Response<Booking> response =  new Response<Booking>();
		try {
			//---Save Addresses
			com.pickme.webapi.document.Address pickupAddress = new com.pickme.webapi.document.Address();
			pickupAddress.setStreet(booking.getPickupAddress().getStreet());
			pickupAddress.setlatitude(booking.getPickupAddress().getlatitude());
			pickupAddress.setlongitude(booking.getPickupAddress().getlongitude());
			com.pickme.webapi.document.Address savedPickupAddress = addressService.addAddress(pickupAddress);
			com.pickme.webapi.document.Address destAddress = new com.pickme.webapi.document.Address();
			destAddress.setStreet(booking.getDestinationAddress().getStreet());
			destAddress.setlatitude(booking.getDestinationAddress().getlatitude());
			destAddress.setlongitude(booking.getDestinationAddress().getlongitude());
			com.pickme.webapi.document.Address savedDestAddress = addressService.addAddress(destAddress);
			
			
			booking.setPickupAddress(savedPickupAddress);
			booking.setDestinationAddress(savedDestAddress);
			//----Set addresses to save in customer
		/*	com.pickme.webapi.model.AddressSearchModel address1 = new com.pickme.webapi.model.AddressSearchModel();
			address1.setAddressId(savedPickupAddress.getId());
			address1.setAddressString(savedPickupAddress.getStreet());
			com.pickme.webapi.model.AddressSearchModel address2 = new com.pickme.webapi.model.AddressSearchModel();
			address2.setAddressId(savedDestAddress.getId());
			address2.setAddressString(savedDestAddress.getStreet());
			com.pickme.webapi.model.AddressSearchModel[] newAdrModel = new com.pickme.webapi.model.AddressSearchModel[2];
			newAdrModel[0]= address1;
			newAdrModel[1]= address2;
			
			*/
			
			
			
			//--- Save Customer
			com.pickme.webapi.document.Customer newCustomer = new com.pickme.webapi.document.Customer();
			
			if(booking.getCustomer() !=null && booking.getCustomer().getId() == null)
			{
				/*newCustomer.setFirstName(booking.getCustomer().getFirstName());*/
				newCustomer = booking.getCustomer();
				//newCustomer.setAddresses(newAdrModel);
				com.pickme.webapi.document.Customer savedCustomer = customerService.addCustomer(newCustomer);
				booking.getCustomer().setId(savedCustomer.getId());
			}
			/*newCustomer.setFirstName(booking.getCustomer().getFirstName());
			newCustomer.setAddresses(newAdrModel);
			com.pickme.webapi.document.Customer savedCustomer = customerService.addCustomer(newCustomer);*/
			//---Set saved customer Id in Booking
			
			//
			Booking savedBooking = bookingService.create(booking);
			String firebaseResponse="";
			    if(savedBooking==null){
					response.setData(savedBooking);
					response.setStatusCode("-1");
					response.setMessage(Response.FAILED);
					response.setSuccessful(true);
					response.setMessageDetail("Invalid Request");
				}else{
					response.setData(savedBooking);
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("New Booking Record is Created.");
					
					
					//----Push Notification
					
					Driver driver = booking.getDriver();
					String driverID = driver.getId();// getLoginId();
					if (driver != null && driverID != null)
					{
						
						firebaseResponse = bookingService.pushNotificationToTopic(driverID,savedBooking.getDriver().getId(),savedBooking.getId(),savedBooking.getDriver().getFirstName());
					//	response.setMessageDetail(firebaseResponse);
				   /* body.put("priority", "high");
				    //body.put("android_channel_id", "pickmecab_updates");
				    
				    
				    JSONObject notification = new JSONObject();
				    notification.put("body","New Job arrived");
				    notification.put("title","New Job");
				    
				    body.put("notification", notification);
				    JSONObject data = new JSONObject();
				    data.put("title", "Job Creation Notification");
				    data.put("body", "New job has been created and assigned to driver");
				  //  data.put("message", "New Job");
				   // data.put("click_action","new_ride");
				    data.put("driver-id", savedBooking.getDriver().getId());
				    data.put("booking-id", savedBooking.getId());
				 
				    
				    
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
				 
				 /*   HttpEntity<String> request = new HttpEntity<>(body.toString());
				 
				    CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
				    CompletableFuture.allOf(pushNotification).join();
				 
				    try {
				      firebaseResponse = pushNotification.get();
				      response.setMessageDetail("New Booking Record is Created."+firebaseResponse);
				     
				    } catch (InterruptedException e) {
				      e.printStackTrace();
				    } catch (ExecutionException e) {
				      e.printStackTrace();
				    }*/
				 
					}
				}

		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, BookingController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		
		return responseEntity;
	}
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> update(@RequestBody Booking booking) {
		String METHOD_NAME = "update";
		Response<Booking> response =  new Response<Booking>();
		try {
			    Booking savedBooking = bookingService.updateBooking(booking);
			    String firebaseResponse="";
			    response.setData(savedBooking);
			    response.setStatusCode("0");
			    response.setMessage(Response.SUCCESSFUL);
			    response.setSuccessful(true);
			    response.setMessageDetail("Booking Record has been successfully Updated.");
			    

				//----Push Notification
				
				Driver driver = booking.getDriver();
				String driverID = driver.getId();// getLoginId();
				if (driver != null && driverID != null)
				{
					
					firebaseResponse = bookingService.pushNotificationToTopic(driverID,savedBooking.getDriver().getId(),savedBooking.getId(),savedBooking.getDriver().getFirstName());
					response.setMessageDetail(firebaseResponse);
				}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> delete(@PathVariable String id) {
		String METHOD_NAME = "delete";
		Response<String> response =  new Response<String>();
		try {
			    boolean success = bookingService.deleteBooking(id);
			    if(success) {
			    	response.setData(id);
				    response.setStatusCode("0");
				    response.setMessage(Response.SUCCESSFUL);
				    response.setSuccessful(true);
				    response.setMessageDetail("Booking Record has been deleted.");
			    }
			    else {
			    	response.setData(id);
				    response.setStatusCode("-1");
				    response.setMessage(Response.FAILED);
				    response.setSuccessful(false);
				    response.setMessageDetail("Delete Operation was not Successful.");
			    }
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
		    response.setMessage(Response.FAILED);
		    response.setSuccessful(false);
		    response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<Response<String>>(response,HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/status/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> updateBookingByStatus(@RequestBody Booking booking) {
		String METHOD_NAME = "updateBookingByStatus";
		Response<Booking> response = new Response<Booking>();
		Booking bookingResponse=null;
		try {
			bookingResponse = bookingService.updateBookingStatus(booking);
			//response.setData(booking);
			if(bookingResponse != null) {
				response.setData(bookingResponse);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				String jsonString = webSocket.buildMessagebooking(bookingResponse);
				webSocket.sendMessage(jsonString);
				response.setMessageDetail("Booking status successfully updated.");
			}
			else {

				response.setStatusCode("-1");
				response.setMessage(Response.FAILED);
				response.setSuccessful(false);
				response.setMessageDetail("Invalid Request");
			}
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/reject/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> reject(@PathVariable String id) {
		String METHOD_NAME = "reject";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.reject(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
				String jsonString = webSocket.buildMessagebooking(savedBooking);
				webSocket.sendMessage(jsonString);
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}

		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/accept/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> accept(@PathVariable String id) {
		String METHOD_NAME = "accept";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.accept(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				String jsonString = webSocket.buildMessagebooking(savedBooking);
				webSocket.sendMessage(jsonString);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}

	
	@RequestMapping(value = "/complete/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> complete(@PathVariable String id) {
		String METHOD_NAME = "complete";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.complete(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				String jsonString = webSocket.buildMessagebooking(savedBooking);
				webSocket.sendMessage(jsonString);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	@RequestMapping(value = "/booked/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> booked(@PathVariable String id) {
		String METHOD_NAME = "booked";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.booked(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/cancelled/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> cancelled(@PathVariable String id) {
		String METHOD_NAME = "cancelled";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.cancelled(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/inprogress/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> inprogress(@PathVariable String id) {
		String METHOD_NAME = "inprogress";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.inprogress(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/dispatch/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> dispatch(@PathVariable String id) {
		String METHOD_NAME = "dispatch";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.dispatch(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/onhold/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> onhold(@PathVariable String id) {
		String METHOD_NAME = "onhold";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.onhold(id);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	
	
	@RequestMapping(value = "/assign/", method = RequestMethod.PUT)
	public ResponseEntity<Response<Booking>> assignDriver(@RequestBody AssignDto assigndto) {
		String METHOD_NAME = "assign";
		Response<Booking> response =  new Response<Booking>();
		try {
			Booking savedBooking = bookingService.assign(assigndto);
			if(savedBooking!=null){
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Booking Record has been successfully Updated.");
			}else{
				response.setData(savedBooking);
				response.setStatusCode("0");
				response.setMessage(Response.SUCCESSFUL);
				response.setSuccessful(true);
				response.setMessageDetail("Unable to update booking");
			}
		}
		catch(Exception ex) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail("ERROR: "+ex.getMessage());
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, CustomerController.class.getName(), METHOD_NAME, ex.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}
		ResponseEntity<Response<Booking>> responseEntity = new ResponseEntity<Response<Booking>>(response,HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	@RequestMapping(value = "/driverBookingBystartTime/{driverId}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Booking>>> getBookingsByDriverIdstartTimeSorted(@PathVariable String driverId,
			@RequestParam(value = "fromDate", required = false)  @DateTimeFormat(pattern="yyyy-MM-dd")java.util.Date fromDate,
		    @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") java.util.Date toDate) {	
		String METHOD_NAME = "getBookingsByDriverIdstartTimeSorted";
		Response<List<Booking>> response = new Response<List<Booking>>();
		try {			
				response = bookingService.getBookingsByDriverIdstartTimeSorted(driverId);
				
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Booking by Driver ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Booking Record Found for Driver ID '"+driverId+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			e.printStackTrace();
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, BookingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Booking>>> responseEntity = new ResponseEntity<Response<List<Booking>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	@RequestMapping(value = "/customerBooking/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Booking>>> getBookingByCustomerId(@PathVariable String customerId,
			@RequestParam(value = "fromDate", required = false)  @DateTimeFormat(pattern="yyyy-MM-dd")java.util.Date fromDate,
		    @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") java.util.Date toDate) {	
		String METHOD_NAME = "getBookingByCustomerId";
		Response<List<Booking>> response = new Response<List<Booking>>();
		try {			
				response = bookingService.getBookingsByCustomerId(customerId, fromDate, toDate);
				
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Booking by Driver ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Booking Record Found for Driver ID '"+customerId+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			e.printStackTrace();
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, BookingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Booking>>> responseEntity = new ResponseEntity<Response<List<Booking>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
	
	
	@RequestMapping(value = "/driverBooking/{driverId}", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Booking>>> getBookingByDriverId(@PathVariable String driverId,
			@RequestParam(value = "fromDate", required = false)  @DateTimeFormat(pattern="yyyy-MM-dd")java.util.Date fromDate,
		    @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") java.util.Date toDate) {	
		String METHOD_NAME = "getBookingByDriverId";
		Response<List<Booking>> response = new Response<List<Booking>>();
		try {			
				response = bookingService.getBookingsByDriverId(driverId, fromDate, toDate);
				
				if(response != null) {			
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("Get Booking by Driver ID request was Successful.");			
				}
				else {
					response.setStatusCode("0");
					response.setMessage(Response.SUCCESSFUL);
					response.setSuccessful(true);
					response.setMessageDetail("No Booking Record Found for Driver ID '"+driverId+"'");
				}		
		}
		catch(Exception e) {
			response.setStatusCode("-1");
			response.setMessage(Response.FAILED);
			response.setSuccessful(false);
			response.setMessageDetail(e.getMessage());
			e.printStackTrace();
			LOGGER.error(ApplicationConstants.MODULE_BOOKING, BookingController.class.getName(), METHOD_NAME, e.getMessage(), ApplicationConstants.APPLICATION_NAME);
		}		
		ResponseEntity<Response<List<Booking>>> responseEntity = new ResponseEntity<Response<List<Booking>>>(response,HttpStatus.OK);				
		return responseEntity;		
	}
}
