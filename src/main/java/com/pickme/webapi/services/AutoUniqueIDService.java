package com.pickme.webapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickme.webapi.document.AutoUniqueID;
import com.pickme.webapi.repo.mongo.AutoUniqueIDRepository;

@Service
public class AutoUniqueIDService {

	@Autowired AutoUniqueIDRepository uniqueIDRepo;
	
	public AutoUniqueID GetNewRef(AutoUniqueID UniID) {
		
		
		
		List<AutoUniqueID> arr = uniqueIDRepo.findAll();
		
		AutoUniqueID NewID  = new AutoUniqueID();// (UniID.getCount());
		
		if (arr == null)
		{
			NewID = new AutoUniqueID();
			NewID.setCount(0);
			NewID.setPrefix(UniID.getPrefix());
			NewID = uniqueIDRepo.insert(NewID);
		}
		else
		{
			NewID = arr.get(0);
			NewID.setCount(NewID.getCount()+1);	
			NewID = uniqueIDRepo.save(NewID);
		}
		
		return NewID;
	}
}
