package com.pickme.webapi.repo.mongo.custom;

import java.util.List;

import com.pickme.webapi.document.Address;

public interface AddressCustomRepository {

	List<Address> search(String term);
}
