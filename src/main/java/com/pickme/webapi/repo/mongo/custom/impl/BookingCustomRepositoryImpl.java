package com.pickme.webapi.repo.mongo.custom.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pickme.webapi.document.Booking;
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.repo.mongo.custom.BookingCustomRepository;

public class BookingCustomRepositoryImpl implements BookingCustomRepository {
	@Override
	public Page<Booking> getBookingByDriver(Driver driver, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
