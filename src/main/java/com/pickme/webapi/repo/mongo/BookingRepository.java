package com.pickme.webapi.repo.mongo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.document.Driver;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String>{
	Page<Booking> findByStatus(String status, Pageable pageable);
	List<Booking> findByStatus(String status);
	List<Booking> findByDriverId(String driverId);
	Page<Booking> findByDriverId(String driverId, Pageable pageable);
	Page<Booking> findAll(Pageable pageable);
	Page<Booking> findByDriver(Driver driver, Pageable pageable);
	Page<Booking> findByCustomer(Customer customer, Pageable pageable);
	Booking findByIdAndDriver(String id,Driver driver);
	/*@Query("{ 'driverId' : ?0 , 'startTime' :{ $gte: ?1, $lte: ?2 }}")
	List<Booking> findByDriverIdAndDate(String driverId, java.util.Date fromDate,java.util.Date toDate );*/
	@Query("{ 'driver' : {'id' :?0} }")
	List<Booking> searchByDriverIdAndDate(String driverId);
	

	
	@Query("{'startTime' : { $gte: ?0, $lte: ?1 } }")                 
	public List<Booking> getObjectBystartTimeAndDriverId(LocalDate strDate, LocalDate mytomorrow, String driverId); 
	
	
}
