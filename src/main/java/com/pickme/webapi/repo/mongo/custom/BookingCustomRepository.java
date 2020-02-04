package com.pickme.webapi.repo.mongo.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pickme.webapi.document.Booking;
import com.pickme.webapi.document.Driver;

public interface BookingCustomRepository {

	Page<Booking> getBookingByDriver(Driver driver, Pageable pageable);
}
