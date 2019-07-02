package com.hrb.endgame.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

import com.hrb.endgame.models.Register;
import com.hrb.endgame.dao.RegisterDao;
import com.hrb.endgame.services.IRegisterService;
import com.hrb.endgame.services.IValidateSessionService;
import com.hrb.endgame.vo.QuestionsVO;
import com.hrb.endgame.vo.RegisterVO;
import com.hrb.endgame.vo.StatusMessage;




@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

	@Autowired
	public RegisterDao regDao;
	
	@Autowired
	public IRegisterService register;
	
	@Autowired
	public IValidateSessionService validSession;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StatusMessage registerUser(@RequestBody RegisterVO user) {
		return register.registerUser(user);
	}
	
	@GetMapping("/all")
	public List<Register> getRegisteredUsers(@RequestHeader("Authorization") String token,@RequestHeader("Name") String email, @RequestHeader("TeamName") String teamName){
		List<Register> registeredDetails = new ArrayList<Register>();
		if(validSession.isValidSession(token, email, teamName)) {

			return regDao.findAll();
		}/*else {
			throw new ResponseStatusException(
			          HttpStatus.UNAUTHORIZED, "Unauthorized Request...");
		}*/
		return registeredDetails;
		
	
	}
	
	@GetMapping("/submitAnswers")
	public StatusMessage getListOfAnswers(@RequestHeader("Authorization") String token,@RequestHeader("Name") String email,
			@RequestHeader("TeamName") String teamName,@RequestBody ArrayList<QuestionsVO> ansList) {
		return register.calculatePoints(ansList,teamName);
	}
	

}
