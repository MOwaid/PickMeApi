package com.pickme.webapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pickme.webapi.document.Customer;
import com.pickme.webapi.model.AddressSearchModel;
import com.pickme.webapi.repo.mongo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.pickme.webapi.document.Address;
import com.pickme.webapi.repo.mongo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepo;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CustomerRepository customerRepository;


	public List<Address> getAllAddress() {
		return addressRepo.findAll();
	}

	public  Address getAddressById(String id) {
		Optional<Address> address = addressRepo.findById(id);
		return address.get();
	}

	public Address addAddress(Address address) {
		
		List<Address> found = addressRepo.findBystreet(address.getStreet());
		if(found == null)
		{	
		setCompleteAddress(address);
		Address newAddress = addressRepo.insert(address);
		return newAddress;
		}
		return address;		
	}

	private void setCompleteAddress(Address address) {
		StringBuffer completeAddress = new StringBuffer();
		completeAddress.append(checkVal(address.getBuildingNumber()));
		completeAddress.append(checkVal(address.getBuildingName()));
		completeAddress.append(checkVal(address.getStreet()));
		completeAddress.append(checkVal(address.getSubBuilding()));
		completeAddress.append(checkVal(address.getArea()));
		completeAddress.append(checkVal(address.getCompany()));
		completeAddress.append(checkVal(address.getPostCode()));
		address.setCompleteAddress(completeAddress.toString().toUpperCase());

	}

	private String checkVal(String text) {
		if(text==null || text.isEmpty())
			return "";
		return text+" ";
	}

	public Address updateAddress(Address address) {
		Address newAddress = addressRepo.save(address);
		return newAddress;
	}

	public boolean deleteAddress(String id) {
		return false; //addressRepo.deleteAddress(id);	
	}

	public List<Address> search(String text) {
		if(text==null)
			text="";
		text = text.toUpperCase();
		List<Address> completeAddressLike = addressRepo.findByCompleteAddressLike(text);
		return completeAddressLike;
	}

	public List<Address> searchByCustomer(String text, String id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer=null;

		if(optional.isPresent())
			customer = optional.get();
		else
			return null;

		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(
						Criteria.where("id").in(getAddressIdList(customer.getAddresses())),
						Criteria.where("completeAddress").regex(text)
				)
		);
		//query.addCriteria(Criteria.where("id").in(getAddressIdList(customer.getAddresses())).and());
		return mongoTemplate.find(query,Address.class);
	}

	private Object getAddressIdList(AddressSearchModel[] addresses) {
		List list= new ArrayList();
		for(AddressSearchModel addressSearchModel : addresses){
			list.add(addressSearchModel.getAddressId());
		}
		return list;
	}
}
