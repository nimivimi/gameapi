package com.hrb.endgame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrb.endgame.models.Register;

public interface RegisterDao extends JpaRepository<Register, Long>{
	List<Register> findByTeamMember5email(String email);
	
	 @Query("select u from Register u where u.teamMember1email = ?1 or u.teamMember2email = ?1 or u.teamMember3email = ?1 or u.teamMember4email = ?1 or u.teamMember5email = ?1")
	 List<Register> findByEmailExist(String email);
	 
	 @Query("select u from Register u where u.teamName = ?1")
	 List<Register> findByTeamNameExist(String teamName);
	 
	 @Query("select u from Register u where u.teamMember1email = ?1 or u.teamMember2email = ?1 or u.teamMember3email = ?1 or u.teamMember4email = ?1 or u.teamMember5email = ?1")
	 Register findByEmail(String email);
	 
}
