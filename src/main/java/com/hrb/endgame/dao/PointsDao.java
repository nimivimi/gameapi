package com.hrb.endgame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hrb.endgame.models.Points;


public interface PointsDao extends JpaRepository<Points, Long>{ @Query("select u from Points u where u.teamName = ?1")
List<Points> findByTeamName(String teamName);

@Query("select u from Points u where u.teamName = ?1")
Points findPointByTeamName(String teamName);

@Transactional
@Modifying(clearAutomatically = true)
@Query("update Points u set u.points = :points where u.teamName = :teamName")
void updatePoint(@Param("teamName") String teamName, @Param("points") int points);

}
