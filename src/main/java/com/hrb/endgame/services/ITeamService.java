package com.hrb.endgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;


import com.hrb.endgame.dao.PointsDao;
import com.hrb.endgame.dao.RegisterDao;
import com.hrb.endgame.models.Points;
import com.hrb.endgame.models.Register;
import com.hrb.endgame.vo.StatusMessage;


public interface ITeamService {
	
	
	
	public List<Points> getPoints(String email);
	
	public String getTeamName(String email);
	public Points getPointsByTeamName(String teamName) ;
	
	public void reducePointsForHint(String teamName) ;
	
	public StatusMessage updateDailyPoints(String teamName, int point) ;
	public List<Points> getAllPoint();
}
