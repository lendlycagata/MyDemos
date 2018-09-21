package com.careercitydashboard.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Model.AccountAnswers;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Model.Questions;
import com.careercitydashboard.Service.AccountAnswersService;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.PositionService;
import com.careercitydashboard.Service.QuestionsService;

@RestController
public class DataController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private AccountAnswersService accountAnswerService;
	
	
	@RequestMapping(path="/accounts", method=RequestMethod.GET)
	public List<Account> getallAccounts(){
		return this.accountService.getallAccounts();
	}
	
	@RequestMapping(path="/positions", method=RequestMethod.GET)
	public List<Position> getallPositions(){
		return this.positionService.getallPositions() ;
	}
	
	@RequestMapping(path="/questions", method=RequestMethod.GET)
	public List<Questions> getallQuestions(){
		return this.questionsService.getallQuestions();
	
	}
	
	@RequestMapping(path="/accountanswers", method=RequestMethod.GET)
	public List<AccountAnswers>  getallAccountAnswers(){
	return this.accountAnswerService.getallAccountAnswers();
	}
}
