package com.hrb.endgame.services;
import java.util.ArrayList;
import java.util.List;
import com.hrb.endgame.models.Register;
import com.hrb.endgame.vo.RegisterVO;
import com.hrb.endgame.vo.StatusMessage;




public interface IRegisterService {	
	
	public boolean checkUserExist(String email);	
	public boolean checkTeamNameExist(String teamName);	
	public void setRegisterPoint(String teamName);
	public List<Register> getAllRegistrations();
	StatusMessage registerUser(RegisterVO user);
	public void calculatePoints(ArrayList<String> ansList);

}
