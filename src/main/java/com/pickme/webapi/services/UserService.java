package com.pickme.webapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.pickme.webapi.common.Response;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.document.Driver;
import com.pickme.webapi.document.User;

import com.pickme.webapi.repo.mongo.LogRepository;
import com.pickme.webapi.repo.mongo.UserRepository;


@Service
public class UserService {
	
	@Autowired UserRepository userRepo;
	@Autowired LogRepository logRepo;
	
	public List<User> search(String parameters) {
		return null;
	}
	public  Response<List<User>> getAllUsers() {
		
		Response<List<User>> response = new Response<List<User>>();
		
		
		List<User> users = userRepo.findAll();
		
		
		
		
		//Page<Booking> pageResult =bookingRepo.findAll(PageRequest.of(first, rows,Sort.by("id").descending()));
		 long totalRecords = users.size();// getTotalElements();
		 response.setData(users);
		 response.setTotalRecords(totalRecords);
		
		
		return response;
	}
	public User getUserById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
	}
	public User findUserById(String id) {
		return null;
	}
	public User findUserByuserName(User user) {
		
		User dbUser = userRepo.findByUserNameAndPasswordAndCompanyCode(user.getUserName(),user.getPassword(),user.getCompanyCode());
		if(dbUser!=null){
			return dbUser;
		}
		return null;
	}
public User findUserByuserId(User user) {
		
		User dbUser = userRepo.findByUserName(user.getUserName());
		if(dbUser!=null){
			return dbUser;
		}
		return null;
	}

	
	public User addUser(User user) {
		
		
		User newUser = userRepo.insert(user);
		return newUser;
	}
	public User updateUser(User user) {
		User newUser = userRepo.save(user);
		return newUser;
	}
	/*public boolean deleteUser(String id) {
		return userRepo.deleteUser(id);	
	}*/
}
