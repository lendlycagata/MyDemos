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
import com.careercitydashboard.Model.Questions;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.PositionService;
import com.careercitydashboard.Service.QuestionsService;

@Controller
public class CommonController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private QuestionsService questionService;
	
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
	@RequestMapping(value="/addaccount", method=RequestMethod.POST)
	public String addAccount(Account account) {
		this.accountService.saveAccount(account);
		return "redirect:/listaccount";
	}
	@RequestMapping(value="/updateaccount" , method=RequestMethod.POST)
	public String updateAccount(Account account) {
		this.accountService.saveAccount(account);
		return "redirect:/listaccount";
	}
	
	
	@RequestMapping(value="/listposition" , method=RequestMethod.GET)
	public String listofallPositions(Model model) throws IOException{
		List<Position> listofallpositions= this.positionService.getallPositions();
		model.addAttribute("allpositions", listofallpositions);
		return "positiontable";
	}
	
	
	
	
}
