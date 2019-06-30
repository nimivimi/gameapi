package com.hrb.endgame.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.hrb.endgame.models.Session;
import com.hrb.endgame.services.ITeamService;
import com.hrb.endgame.services.IValidateSessionService;
import com.hrb.endgame.dao.LoginDao;


@Service
@Configurable
public class ValidateSessionServiceImpl implements IValidateSessionService{

	public ValidateSessionServiceImpl() {
		
	}
	
	@Autowired
	public LoginDao loginDao;
	
	@Autowired
	public ITeamService teamService;
	
	public boolean isValidSession(String token, String email, String teamName) {
		Session data = getActiveSessionData(email);
		String teamNameFound = teamService.getTeamName(email);
		
		if(data!=null) {
			if(data.getEmail().equals(email) && data.getToken().equals(token) && teamNameFound.equals(teamName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkActiveSession(String email) {
		return loginDao.findByEmail(email).isEmpty()? false: true;
	}
	
	public Session getActiveSessionData(String email) {
		
		return loginDao.getDataByEmail(email);
		
	}
	
	public boolean isValidAdmin(String authKey, String username, String password) {
		
		String key = "B20A9C1F7BE226063FC5F311365FE79EFB7409275C73B7C092A4AC7764399127";
		String user = "admin@endgame";
		String pass = "admin@hrb@endgame";
		
		if(key.equals(authKey) && user.equals(username) && pass.equals(password)) {
			return true;
		}
		
		return false;
	}
	
}

