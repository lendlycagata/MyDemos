package com.careercitydashboard.Controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.PositionService;

@Controller
public class CommonController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PositionService positionService;
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("welcome", "Career City Admin Dashboard");
		return "index";
	}
	
	@RequestMapping(value="/listaccount", method=RequestMethod.GET)
	
	public String listofallAccounts(Model model) throws IOException{
		List<Account> listofallaccounts= this.accountService.getallAccounts();
		
		model.addAttribute("allaccounts", listofallaccounts);
		
		return "accounttable";
	}
	
	
	@RequestMapping(value="/listposition" , method=RequestMethod.GET)
	public String listofallPositions(Model model) throws IOException{
		List<Position> listofallpositions= this.positionService.getallPositions();
		model.addAttribute("allpositions", listofallpositions);
		return "positiontable";
	}
	
	
	
	
}
