package com.pickme.webapi.repo.mongo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Fare;
import com.pickme.webapi.repo.mongo.custom.FareCustomRepository;

public interface FareRepository extends MongoRepository<Fare, String>,FareCustomRepository {
	public List<Fare> findByDayFare(String dayFare);
	public List<Fare> findByNightFare(String nightFare);
	public List<Fare> findByWaitFare(String waitFare);
	public List<Fare> findBySpecialFee(String specialFee);
	public List<Fare> findBySpecialDiscount(String specialDiscount);
	public List<Fare> findByCreatedBy(String createdBy);
	public List<Fare> findByUpdatedBy(String updatedBy);
	public List<Fare> findByDeleted(boolean deleted);
	Page<Fare> findByDeleted(boolean deleted, Pageable pageable);

}


