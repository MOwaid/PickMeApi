package com.pickme.webapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Customer;
import com.pickme.webapi.repo.mongo.CustomerRepository;
import com.pickme.webapi.repo.mongo.LogRepository;

@Service
public class CustomerService {

	@Autowired CustomerRepository customerRepo;
	@Autowired LogRepository logRepo;
	
	public Response<List<Customer>> getAllCustomers(Integer first, Integer rows, String globalFilter, String sortOrder) {
		Response<List<Customer>> response = new Response<List<Customer>>();
		if(first != null & rows != null) {
			if(first > 0) {
				rows+=first;
			}
			Page<Customer> pageResult = customerRepo.findByDeleted(false, PageRequest.of(first, rows));
			long totalRecords = pageResult.getTotalElements();
			response.setData(pageResult.getContent());
			response.setTotalRecords(totalRecords);
		}
		return response;
	}
	public Customer getCustomerById(String id) {
		Optional<Customer> customer = customerRepo.findById(id);
		return customer.get();
	}
	public Customer getCustomerByPhone(String phone) {
		return customerRepo.findByPhone(phone);
		//return customer.get();
	}
	public Customer getCustomerByPhoneAndEmail(String phone,String email) {
		Customer customer = customerRepo.findByPhoneAndEmail(phone, email);
		return customer;
	}
	public Customer addCustomer(Customer customer) {
		Customer newCustomer = customerRepo.insert(customer);
		return newCustomer;
	}
	public Customer updateCustomer(Customer customer) {
		Customer newCustomer = customerRepo.save(customer);
		return newCustomer;
	}
	public boolean deleteCustomer(String id) {
		return customerRepo.deleteCustomer(id);		
	}
}
