package com.careercitydashboard.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careercitydashboard.Dao.AccountRepo;
import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public List<Account> getallAccounts() {
		
		return (List<Account>) this.accountRepo.findAll();
	}

	@Override
	public Account getaccountbyId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return this.accountRepo.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return this.accountRepo.save(account);
	}

}
