package com.careercitydashboard.Controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.ListUtils;

import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Model.AccountAnswers;
import com.careercitydashboard.Model.Answer;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Model.Questions;
import com.careercitydashboard.Model.Site;
import com.careercitydashboard.Model.Users;
import com.careercitydashboard.Service.AccountAnswersService;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.AnswerService;
import com.careercitydashboard.Service.PositionService;
import com.careercitydashboard.Service.QuestionsService;
import com.careercitydashboard.Service.SiteService;
import com.careercitydashboard.Service.UsersService;

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
	@Autowired
	private AnswerService answerService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private UsersService usersService;
	
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
	
	@RequestMapping(path="/answers", method=RequestMethod.GET)
	public List<Answer> getallAnswers(){
		return this.answerService.getallAnswer();
	}
	
	
	@RequestMapping(path="/accountanswers", method=RequestMethod.GET)
	public List<AccountAnswers>  getallAccountAnswers(){
	return this.accountAnswerService.getallAccountAnswers();
	}
	@RequestMapping(path="/accountmap/{id}" , method=RequestMethod.GET)
	public Account getaccountmapbyId(@PathVariable(value = "id")Integer ACCOUNT_ID) {
		return this.accountService.getAccountMapping(ACCOUNT_ID);
	}
	
	@GetMapping("/sitelist")
	public List<Site> getAllSiteListJson(){
		return this.siteService.getAllSiteList();
	}
	

	
	
	@GetMapping("/imagelist")
	public List<String> getAllImage() throws IOException {
		
		List<String> imagelist = new ArrayList<>();
		String url="C://things";
		/*String url="//opt/tomcat/webapps/ImageRepo//";*/
		
		String link="https://35.185.222.6/ImageRepo/";
		File folder = new File(url);
		File [] listOfFiles = folder.listFiles();
		
		
		for(File file: listOfFiles ) {
			imagelist.add(link + file.getName()); 
			System.out.println("https://35.185.222.6/ImageRepo/" + file.getName());
		}
		
		return imagelist;
		
		
				
	}
	
	@GetMapping("/userlist")
	public List<Users> getAllUsers(){
		return (List<Users>)this.usersService.getAllUsers();
	}

		
}
