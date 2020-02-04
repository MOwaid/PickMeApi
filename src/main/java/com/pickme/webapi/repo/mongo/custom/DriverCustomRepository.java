package com.pickme.webapi.repo.mongo.custom;

import java.util.List;

import com.pickme.webapi.document.Driver;

public interface DriverCustomRepository {

	public boolean deleteDriver(String id);
	public List<Driver> search(String term);
}
