/**
 * 
 */
package com.pickme.webapi.repo.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pickme.webapi.document.Booking;
import com.pickme.webapi.document.User;


/**
 * @author muhammed
 *
 */
public interface UserRepository extends MongoRepository<User, String>{

	public List<User> findByDeleted(boolean deleted);
	public List<User> findAllBy(TextCriteria criteria);
	public List<User> findAll();
	User findByUserNameAndPasswordAndCompanyCode(String userName,String Password,String CompanyCode);
	User findByUserName(String userName);
}
