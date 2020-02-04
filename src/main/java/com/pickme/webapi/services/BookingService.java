package com.pickme.webapi.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pickme.webapi.common.ApplicationConstants;
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.model.AssignDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.repo.mongo.BookingRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class BookingService {
	@Autowired BookingRepository bookingRepo;
	@Autowired LogRepository logRepo;
	public Response<List<Booking>> getAllBookings(Integer first,Integer rows, String globalFilter,String sortOrder) {
		Response<List<Booking>> response = new Response<List<Booking>>();
		if(first != null & rows != null) {
			if(first > 0) {
				rows+=first;
			}
			Page<Booking> pageResult = bookingRepo.findAll(PageRequest.of(first, rows));
			long totalRecords = pageResult.getTotalElements();
			response.setData(pageResult.getContent());
			response.setTotalRecords(totalRecords);
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
		
		
		/*List<Booking> bookingList = bookingRepo.findByDriverIdAndDate(driverId,fromDate,toDate);*/
		List<Booking> bookingList = bookingRepo.findByDriverId(driverId);
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

		return bookingRepo.save(updatedBoking);
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
				booking.setStatus(ApplicationConstants.BOOKING_STATUS_PRE_BOOKED);
			}

		}else{
			//if(currentDate.compareTo(bookingStartDate)==0)
				booking.setStatus(ApplicationConstants.BOOKING_STATUS_ALLOCATED);
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

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_CONFIRMED);
		return bookingRepo.save(booking);
	}

	public Booking complete(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_COMPLETED);
		return bookingRepo.save(booking);
	}
	
	public Booking reject(String id) {
		Optional<Booking> optional = bookingRepo.findById(id);
		Booking booking  = optional.get();
		if(booking==null)
			return null;

		booking.setStatus(ApplicationConstants.BOOKING_STATUS_BOOKED);
		booking.setDriver(null);
		return bookingRepo.save(booking);
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
