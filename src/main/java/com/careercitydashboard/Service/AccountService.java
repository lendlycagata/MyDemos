package com.careercitydashboard.Service;

import java.util.List;

import com.careercitydashboard.Model.Account;

public interface AccountService {
	
	public List<Account> getallAccounts();
	public Account getaccountbyId(Integer Id);
	public Account saveAccount(Account account);
	public Account updateAccount(Account account);
	public Account getAccountMapping(Integer ACCOUNT_ID);
}
