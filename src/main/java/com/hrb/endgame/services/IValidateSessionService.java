package com.hrb.endgame.services;



import com.hrb.endgame.models.Session;




public interface IValidateSessionService {

	
	
	public boolean isValidSession(String token, String email, String teamName) ;
	
	public boolean checkActiveSession(String email) ;
	public Session getActiveSessionData(String email) ;
	
	public boolean isValidAdmin(String authKey, String username, String password) ;
}

