package com.hrb.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrb.endgame.models.Register;

public interface RegisterDao extends JpaRepository<Register, Long>{

}
