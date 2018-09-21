package com.careercitydashboard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.PositionService;

@RestController
public class DataController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private PositionService positionService;
	
	
	@RequestMapping(path="/accounts", method=RequestMethod.GET)
	public List<Account> getallAccounts(){
		return accountService.getallAccounts();
	}
	
	@RequestMapping(path="/positions", method=RequestMethod.GET)
	public List<Position> getallPositions(){
		return positionService.getallPositions() ;
	}
	
}
