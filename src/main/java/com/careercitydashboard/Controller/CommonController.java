package com.careercitydashboard.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.ListUtils;

import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Model.AccountAnswers;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Model.PositionAnswers;
import com.careercitydashboard.Model.Site;
import com.careercitydashboard.Model.Users;
import com.careercitydashboard.Service.AccountAnswersService;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.AnswerService;
import com.careercitydashboard.Service.PositionAnswerService;
import com.careercitydashboard.Service.PositionService;
import com.careercitydashboard.Service.QuestionsService;
import com.careercitydashboard.Service.SiteService;
import com.careercitydashboard.Service.UsersService;
import com.careercitydashboard.ServiceImpl.UsersDetailServiceImpl;
import com.careercitydashboard.util.ShowImageList;
import com.careercitydashboard.util.UploadUtility;

@Controller
public class CommonController {
	
	private  final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private QuestionsService questionService;

	@Autowired
	private AccountAnswersService accountAnswersService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private PositionAnswerService positionAnswerService;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private UploadController uploadController;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private UsersDetailServiceImpl usersDetSerImpl;
	

	@RequestMapping("/")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("last logged by" + auth.getName());
		model.addAttribute("welcome", " ");
		return "home";
	}
	
	

	@RequestMapping(value = "/listaccount", method = RequestMethod.GET)

	public String listofallAccounts(Model model) throws IOException {
		logger.debug("accounttable");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		logger.info("last logged by" + auth.getName());
		model.addAttribute("lastsavedby", username);
		
		List<Account> listofallaccounts = this.accountService.getallAccounts();

		model.addAttribute("allaccounts", listofallaccounts);

		return "accounttable";
	}

	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public String addAccount(Account account , @RequestParam("file") MultipartFile file) {
		UploadUtility upload = new UploadUtility();
		if (!file.isEmpty())
			upload.singleFileUpload(file);
	
		this.accountService.saveAccount(account);
		return "redirect:/listaccount";
	}


	@RequestMapping(value = "/updateaccount", method = RequestMethod.POST)
	public String updateAccount(Account account ,@RequestParam("file") MultipartFile file ) {
		UploadUtility upload = new UploadUtility();
		if (!file.isEmpty())
			upload.singleFileUpload(file);
	
		this.accountService.updateAccount(account);
		return "redirect:/listaccount";
	}
	


	@RequestMapping(value = "/accountmaps/{id}", method = RequestMethod.GET)
	public String getaccountmapbyId(@PathVariable("id") Integer ACCOUNT_ID, Model model) {
		System.out.println(ACCOUNT_ID);
		Account getmapdetails = this.accountService.getAccountMapping(ACCOUNT_ID);
		System.out.println(getmapdetails.toString());
		model.addAttribute("mapdetails", getmapdetails);

		return "accountmap";
	}

	@RequestMapping(value = "/addaccountanswers", method = RequestMethod.POST)
	public String addAccountMapping(AccountAnswers accountAnswers) {
		this.accountAnswersService.addAccountAnswers(accountAnswers);
		System.out.println(accountAnswers.toString());
		return "redirect:/accountmaps/" + accountAnswers.getACCOUNT_ID();
	}

	@RequestMapping(value = "/deleteaccountmap", method = RequestMethod.POST)
	public String deleteAccountMapping(@RequestParam Integer QUESTION_ANSWER_ID, @RequestParam Integer ACCOUNT_ID) {
		System.out.println(QUESTION_ANSWER_ID);
		this.accountAnswersService.deleteMapping(QUESTION_ANSWER_ID);
		return "redirect:/accountmaps/" + ACCOUNT_ID;
	}

	@RequestMapping(value = "/listposition", method = RequestMethod.GET)
	public String listofallPositions(Model model) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		logger.info("last logged by" + auth.getName());
		model.addAttribute("modify_by", username);
		
		
		List<Position> listofallpositions = this.positionService.getallPositions();
		model.addAttribute("allpositions", listofallpositions);
		return "positiontable";
	}

	@RequestMapping(value = "/updateposition", method = RequestMethod.POST)
	public String updatePosition(Position position, @RequestParam("file") MultipartFile file ) {
		// For uploading the image to repository
		UploadUtility upload = new UploadUtility();
		if (!file.isEmpty())
			upload.singleFileUpload(file);
		this.positionService.updatePosition(position);
		return "redirect:/listposition";
	}

	@RequestMapping(value = "/addposition", method = RequestMethod.POST)
	public String addPosition(Position position ,  @RequestParam("file") MultipartFile file) {
		UploadUtility upload = new UploadUtility();
		if (!file.isEmpty())
			upload.singleFileUpload(file);
		
		this.positionService.savePosition(position);
		return "redirect:/listposition";
	}

	@RequestMapping(value = "/positionmaps/{id}", method = RequestMethod.GET)
	public String getPositionMapById(@PathVariable("id") Integer POSITION_ID, Model model) {
		// System.out.println(POSITION_ID);
		Position getPositionMapDetails = this.positionService.getPositionMapping(POSITION_ID);
		// System.out.println(getPositionMapDetails.toString());
		model.addAttribute("positionmaps", getPositionMapDetails);

		return "positionmaps";

	}

	@RequestMapping(value = "/addpositionanswers", method = RequestMethod.POST)
	public String addPositionMapping(PositionAnswers positionAnswers) {
		System.out.println(positionAnswers);
		this.positionAnswerService.addPositionAnswers(positionAnswers);

		return "redirect:/positionmaps/" + positionAnswers.getPOSITION_ID();
	}

	@RequestMapping(value = "/deletepositionmap", method = RequestMethod.POST)
	public String deletePositionMapping(@RequestParam Integer QUESTION_ANSWER_ID, @RequestParam Integer POSITION_ID) {
		this.positionAnswerService.deletePositionMapping(QUESTION_ANSWER_ID);
		return "redirect:/positionmaps/" + POSITION_ID;
	}
	
	@RequestMapping(value="/sites" , method=RequestMethod.GET)
	public String listOfAllSites(Model model) {
		List <Site> getListOfAllSites= this.siteService.getAllSiteList();
		model.addAttribute("sitelist", getListOfAllSites);
		return "SiteTable";
	}
	
	@RequestMapping(value="/addnewsite", method=RequestMethod.POST)
	public String addNewSite(Site site) {
		this.siteService.addSite(site);
		return "redirect:/sites";
	}
	@RequestMapping(value="/deletesite", method=RequestMethod.POST)
	public String deleteSite(Integer SITE_ID) {
		this.siteService.deleteSite(SITE_ID);
		return "redirect:/sites";
	}
	
	
	
	
	/*users table*/
	@RequestMapping(value="/allusers" , method=RequestMethod.GET)
	public String allUserList(Model model ) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		logger.info("last logged by" + auth.getName());
		model.addAttribute("changedby", username);
		
	 List <Users> allUsers= this.userService.getAllUsers();
	 model.addAttribute("alluserslist", allUsers);
	 return "userspage";
	}
	
	@RequestMapping(value="/adduser" , method=RequestMethod.POST)
	public String Users(Users users) {
		this.userService.addUsers(users);
		return "redirect:/allusers";
	}

	

	@RequestMapping(value="/edituser" , method=RequestMethod.POST)
	public String editUser(Users users ) {
		
		this.userService.updateUsers(users);
		return "redirect:/allusers";

	}
	
	@RequestMapping(value="/modaltester")
	public String allImageList( )  {
		
		return "testmodal";
		
	}
	

}
