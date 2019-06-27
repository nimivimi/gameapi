package com.hrb.endgame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="register")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Register {
	@Id
	@Column(updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private String teamName;
	private String teamMember1email;
	private String teamMember2email;
	private String teamMember3email;
	private String teamMember4email;
	private String teamMember5email;

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamMember1email() {
		return teamMember1email;
	}
	public void setTeamMember1email(String teamMember1email) {
		this.teamMember1email = teamMember1email;
	}
	public String getTeamMember2email() {
		return teamMember2email;
	}
	public void setTeamMember2email(String teamMember2email) {
		this.teamMember2email = teamMember2email;
	}
	public String getTeamMember3email() {
		return teamMember3email;
	}
	public void setTeamMember3email(String teamMember3email) {
		this.teamMember3email = teamMember3email;
	}
	public String getTeamMember4email() {
		return teamMember4email;
	}
	public void setTeamMember4email(String teamMember4email) {
		this.teamMember4email = teamMember4email;
	}
	public String getTeamMember5email() {
		return teamMember5email;
	}
	public void setTeamMember5email(String teamMember5email) {
		this.teamMember5email = teamMember5email;
	}
}

