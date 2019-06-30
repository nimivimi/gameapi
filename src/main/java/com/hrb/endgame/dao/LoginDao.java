package com.hrb.endgame.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.hrb.endgame.models.Session;

public interface LoginDao extends JpaRepository<Session, Long>{
List<Session> findByEmail(String email);
	
	@Transactional    
	@Modifying
	@Query(value="DELETE FROM Session WHERE email=?1", 
	    nativeQuery = true)
	void deleteByEmail(String email);

	@Query("select u from Session u where u.email = ?1")
	Session getDataByEmail(String email);
	
}
