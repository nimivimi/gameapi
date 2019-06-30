package com.hrb.endgame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;

import com.hrb.endgame.models.Points;
import com.hrb.endgame.models.Register;
import com.hrb.endgame.dao.PointsDao;
import com.hrb.endgame.dao.RegisterDao;
import com.hrb.endgame.services.ITeamService;
import com.hrb.endgame.vo.StatusMessage;

@Service
@Configurable
public class TeamServiceImpl implements ITeamService{
	
	public TeamServiceImpl() {
		
	}
	
	@Autowired
	public PointsDao pointDao;
	
	@Autowired
	public RegisterDao regDao;
	
	Points point = new Points(); 
	StatusMessage statusMsg = new StatusMessage();
	
	public List<Points> getPoints(String email){
		String teamName = getTeamName(email);
		return pointDao.findByTeamName(teamName);
	}
	
	public String getTeamName(String email) {
		
		Register reg = regDao.findByEmail(email);
		if(reg != null) {
			return reg.getTeamName();
		}else {
			return "Cannot find Team name";
		}
	}
	
	
	public Points getPointsByTeamName(String teamName) {
		List<Points> points = pointDao.findByTeamName(teamName);
	
		if(!points.isEmpty()) {
			point = points.get(0);
			System.out.println(point);
		}
		return pointDao.findPointByTeamName(teamName);
	}
	
	public void reducePointsForHint(String teamName) {
		
		 int points = getPointsByTeamName(teamName).getPoints();
		 points = points-5;
		 pointDao.updatePoint(teamName, points);
	}
	
	public StatusMessage updateDailyPoints(String teamName, int point) {
		try {

			int currentPoints = getPointsByTeamName(teamName).getPoints();
			currentPoints = currentPoints+point;
			pointDao.updatePoint(teamName, currentPoints);
			statusMsg.setMessage("Points updated Successfully");
			statusMsg.setStatus("Success");
			return statusMsg;
		}
		catch(Exception ex) {
			/*throw new ResponseStatusException(
			          HttpStatus.CONFLICT, "Error Occured, Error Message :"+ex);*/
		}
		return statusMsg;
	}

	public List<Points> getAllPoint(){
		return pointDao.findAll();
	}
}
