package com.careercitydashboard.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.careercitydashboard.Model.Account;
import com.careercitydashboard.Model.AccountAnswers;
import com.careercitydashboard.Model.Position;
import com.careercitydashboard.Model.PositionAnswers;
import com.careercitydashboard.Service.AccountAnswersService;
import com.careercitydashboard.Service.AccountService;
import com.careercitydashboard.Service.AnswerService;
import com.careercitydashboard.Service.PositionAnswerService;
import com.careercitydashboard.Service.PositionService;
import com.careercitydashboard.Service.QuestionsService;
import com.careercitydashboard.util.UploadUtility;

@Controller
public class CommonController {

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

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("welcome", "Career City Admin Dashboard");
		return "redirect:/login";
	}

	@RequestMapping(value = "/listaccount", method = RequestMethod.GET)

	public String listofallAccounts(Model model) throws IOException {
		List<Account> listofallaccounts = this.accountService.getallAccounts();

		model.addAttribute("allaccounts", listofallaccounts);

		return "accounttable";
	}

	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public String addAccount(Account account) {
		this.accountService.saveAccount(account);
		return "redirect:/listaccount";
	}

	@RequestMapping(value = "/updateaccount", method = RequestMethod.POST)
	public String updateAccount(Account account, @RequestParam("file") MultipartFile file) {

		// For uploading the image to repository
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
	public String addPosition(Position position) {
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

}
