package com.pickme.webapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
	public List<User> getAllUsers() {
		List<User> users = userRepo.findByDeleted(false);
		return users;
	}
	public User getUserById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
	}
	public User findUserById(String id) {
		return null;
	}
	public User findUserByuserName(User user) {
		
		User dbUser = userRepo.findByUserNameAndPassword(user.getUserName(),user.getPassword());
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
