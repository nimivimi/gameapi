package com.hrb.endgame.services.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import org.springframework.web.server

import com.hrb.endgame.models.Points;
import com.hrb.endgame.models.Register;
import com.hrb.endgame.models.Session;
import com.hrb.endgame.dao.LoginDao;
import com.hrb.endgame.dao.PointsDao;
import com.hrb.endgame.dao.RegisterDao;
import com.hrb.endgame.services.IRegisterService;
import com.hrb.endgame.vo.RegisterVO;
import com.hrb.endgame.vo.StatusMessage;

@Service
@Configurable
public class RegisterServiceImpl implements IRegisterService{
	
	public RegisterServiceImpl() {
	   }
	
	@Autowired
	public RegisterDao regDao;
	
	@Autowired 
	PointsDao pointsDao;
	
	
	
	Points point = new Points();
	StatusMessage message = new StatusMessage();
	public boolean checkUserExist(String email) {
		return regDao.findByEmailExist(email).isEmpty()? false: true; 
	}
	
	public boolean checkTeamNameExist(String teamName) {
		return regDao.findByTeamNameExist(teamName).isEmpty()? false: true;
	}
	
	/*public StatusMessage registerUser(Register user) {
			if(checkUserExist(user.getTeamMember1email()) || 
				checkUserExist(user.getTeamMember2email()) || 
				checkUserExist(user.getTeamMember3email()) || 
				checkUserExist(user.getTeamMember4email()) || 
				checkUserExist(user.getTeamMember5email())
				) {
				
				throw new Exception(
				         "One of the user already registered");
		}
			else if(checkTeamNameExist(user.getTeamName()))	{
				throw new Exception(
				         "Team already registered");
			}
		else {
			regDao.save(user);
			setRegisterPoint(user.getTeamName());
			message.setStatus("Success");
			message.setMessage("You have Registered Successfully");
			return message;
		}	
	}*/
	
	
	public void setRegisterPoint(String teamName) {
		
		point.setTeamName(teamName);
		if(regDao.findAll().size()<=10) {
			point.setPoints(10);
		}else {
			point.setPoints(5);
		}
		
		pointsDao.save(point);
	}
	
	public List<Register> getAllRegistrations(){
		return regDao.findAll();
	}

	@Override
	public StatusMessage registerUser(RegisterVO user) {
		
		StatusMessage statusMessage = new StatusMessage();
		List<Register> registeredUsers=regDao.findAll();
		if(null!=user && null != registeredUsers) {
			
			if(isUserExists(user,registeredUsers)) {
				statusMessage.setMessage("Team name or users/one of the users already registered");
				statusMessage.setStatus("Fail");
				System.out.println("Team name or users already registered");
			}else {
				
				regDao.save(setRegister(user));
				setRegisterPoint(user.getTeamName());
				statusMessage.setMessage("Team registered successfully");
				statusMessage.setStatus("Success");
				System.out.println("Team registered successfully");
			}
				
		}
		
		return statusMessage;
	}

	private Register setRegister(RegisterVO user) {
		Register r= new Register();
		//r.setId(user.getId());
		r.setTeamMember1email(user.getTeamMember1email());
		r.setTeamMember2email(user.getTeamMember2email());
		r.setTeamMember3email(user.getTeamMember3email());
		r.setTeamMember4email(user.getTeamMember4email());
		r.setTeamMember5email(user.getTeamMember5email());
		r.setTeamName(user.getTeamName());
		return r;
		
	}

	private boolean isUserExists(RegisterVO user, List<Register> registeredUsers) {
		
		ArrayList<String> emailLists = new ArrayList<String>();
		for(Register register:registeredUsers) {
			
			emailLists.add(register.getTeamMember1email())	;
			emailLists.add(register.getTeamMember2email())	;
			emailLists.add(register.getTeamMember3email())	;
			emailLists.add(register.getTeamMember4email())	;
			emailLists.add(register.getTeamMember5email())	;
			emailLists.add(register.getTeamName());
		}
		return (emailLists.contains(user.getTeamMember1email()) || 
				emailLists.contains(user.getTeamMember2email()) || 
				emailLists.contains(user.getTeamMember3email()) || 
				emailLists.contains(user.getTeamMember4email()) || 
				emailLists.contains(user.getTeamMember5email()) ||
				emailLists.contains(user.getTeamName())
				)?true :false; 
			
		
		
		
		
	}

	@Override
	public void calculatePoints(ArrayList<String> ansList) {
		int points = 0;
		HashMap<Integer,String> ansMap= getAnsMap();
		 for(Map.Entry m:ansMap.entrySet()){ 
			 if(ansList.get((int) m.getKey()).equalsIgnoreCase((String) m.getValue())) {
				 points++; 
			 }
		 }
		 point.setPoints(points);
		 pointsDao.save(point);
		
		
	}
   public HashMap<Integer,String> getAnsMap() {
	   HashMap<Integer,String> ansList=new HashMap<Integer,String>();
	   ansList.put(1,"A");    
	   ansList.put(2,"C");    
	   ansList.put(3,"B");
	   ansList.put(4,"A");
	   ansList.put(5,"D");
	   ansList.put(6,"B");
	   ansList.put(7,"B");
	   ansList.put(8,"A");
	   ansList.put(9,"D");
	   ansList.put(10,"C");
	   
	return ansList; 
   }


}
