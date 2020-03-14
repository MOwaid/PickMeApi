package com.pickme.webapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.pickme.webapi.document.CAccount;
import com.pickme.webapi.document.AutoUniqueID;
import com.pickme.webapi.document.Booking;
import com.pickme.webapi.common.Response;
import com.pickme.webapi.repo.mongo.CAccountRepository;

@Service
public class CAccountService {

	@Autowired CAccountRepository Accrepo;
	
	public Response<List<CAccount>> getAllAccounts(Integer first,Integer rows, String globalFilter,String sortOrder) {
		Response<List<CAccount>> response = new Response<List<CAccount>>();
		if(first != null & rows != null) {
			if(first > 0) {
				rows+=first;
			}
			Page<CAccount> pageResult = Accrepo.findAll(PageRequest.of(first, rows));
			long totalRecords = pageResult.getTotalElements();
			response.setData(pageResult.getContent());
			response.setTotalRecords(totalRecords);
		}
		return response;
	}
	
	public CAccount getAccountById(String id) {
		Optional<CAccount> account = Accrepo.findById(id);
		return account != null ? account.get() : null;
	}
	
	public CAccount create(CAccount accObj) {
		
		
		return Accrepo.insert(accObj);
	}
	public CAccount updateAccount(CAccount accObj) {
		String id  = accObj.getId();
		
		
		Optional<CAccount> updateAccountOptional = Accrepo.findById(id);
		CAccount updatedAcc = updateAccountOptional.get();
		if(updateAccountOptional==null && updatedAcc==null )
			return null;
		//updatedBoking.setStatus(accObj.getStatus());
		updatedAcc = accObj;

		return Accrepo.save(accObj);
	}
	
	public CAccount updateAccountStatus(CAccount accountObj) {
		Optional<CAccount> accountOptional = Accrepo.findById(accountObj.getId());
		if(accountOptional ==null || accountOptional.get()==null)
			return null;
		CAccount dbAccount = accountOptional.get();
		if(dbAccount!=null){
			dbAccount.setStatus(accountObj.getStatus());
			return Accrepo.save(dbAccount);
		}else{
			return null;
		}
	}
	
	
}
