package com.pickme.webapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.pickme.webapi.document.Account;
import com.pickme.webapi.document.AutoUniqueID;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.common.Response;
import com.pickme.webapi.repo.mongo.AccountRepository;

@Service
public class AccountService {

	@Autowired AccountRepository Accrepo;
	
	public Response<List<Account>> getAllAccounts(Integer first,Integer rows, String globalFilter,String sortOrder) {
		Response<List<Account>> response = new Response<List<Account>>();
		if(first != null & rows != null) {
			if(first > 0) {
				rows+=first;
			}
			Page<Account> pageResult = Accrepo.findAll(PageRequest.of(first, rows));
			long totalRecords = pageResult.getTotalElements();
			response.setData(pageResult.getContent());
			response.setTotalRecords(totalRecords);
		}
		return response;
	}
	
	public Account getAccountById(String id) {
		Optional<Account> account = Accrepo.findById(id);
		return account != null ? account.get() : null;
	}
	
	public Account create(Account accObj) {
		
		
		return Accrepo.insert(accObj);
	}
	public Account updateAccount(Account accObj) {
		String id  = accObj.getId();
		
		
		Optional<Account> updateAccountOptional = Accrepo.findById(id);
		Account updatedAcc = updateAccountOptional.get();
		if(updateAccountOptional==null && updatedAcc==null )
			return null;
		//updatedBoking.setStatus(accObj.getStatus());
		updatedAcc = accObj;

		return Accrepo.save(accObj);
	}
	
	public Account updateAccountStatus(Account accountObj) {
		Optional<Account> accountOptional = Accrepo.findById(accountObj.getId());
		if(accountOptional ==null || accountOptional.get()==null)
			return null;
		Account dbAccount = accountOptional.get();
		if(dbAccount!=null){
			dbAccount.setStatus(accountObj.getStatus());
			return Accrepo.save(dbAccount);
		}else{
			return null;
		}
	}
	
	
}
