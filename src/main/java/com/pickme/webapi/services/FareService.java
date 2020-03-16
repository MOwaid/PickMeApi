package com.pickme.webapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Fare;
import com.pickme.webapi.repo.mongo.FareRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class FareService {

	@Autowired FareRepository fareRepo;
	@Autowired LogRepository logRepo;
	
	public List<Fare> getAllFares() {
		List<Fare> fares = fareRepo.findByDeleted(false); 
		return fares;
	}
	public Fare getFareById(String id) {
		Optional<Fare> fare = fareRepo.findById(id);
		return fare.get();
	}
	public List<Fare> getFareByDayFare(String dayFare) {
		List<Fare> fares = fareRepo.findByDayFare(dayFare); 
		return fares;
	}
	public List<Fare> getFareByNightFare(String nightFare) {
		List<Fare> fares = fareRepo.findByNightFare(nightFare);
		return fares;
	}
	public List<Fare> getFareByWaitFare(String waitFare) {
		List<Fare> fares = fareRepo.findByWaitFare(waitFare);
		return fares;
	}
	public List<Fare> getFareBySpecialDiscount(String specialDiscount) {
		List<Fare> fares= fareRepo.findBySpecialDiscount(specialDiscount);
		return fares;
	}
	public List<Fare> getFareBySpecialFee(String specialFee) {
		List<Fare> fares= fareRepo.findBySpecialFee(specialFee);
		return fares;
	}
	public List<Fare>  getFareByCreatedBy(String createdBy) {
		List<Fare> fares=  fareRepo.findByCreatedBy(createdBy);
		return fares;
	}
	public List<Fare>  getFareByUpdatedBy(String updatedBy) {
		List<Fare> fares=  fareRepo.findByUpdatedBy(updatedBy);
		return fares;
	}
	public Fare addFare(Fare fare) {
		Fare newFare = fareRepo.insert(fare);
		return newFare;
	}
	public Fare updateFare(Fare fare) {
		Fare newFare = fareRepo.save(fare);
		return newFare;
	}
	public boolean deleteFare(String id) {
		return fareRepo.deleteFare(id);
	}
}
