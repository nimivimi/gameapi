package com.hrb.endgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrb.endgame.dao.RegisterDao;
import com.hrb.endgame.models.Register;
import com.hrb.endgame.models.TestModel;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

	TestModel model = new TestModel();

	@Autowired
	RegisterDao regDao;
	
	@GetMapping
	public TestModel getData() {
		model.setMesssage("Test working");
		model.setStatus("Success");
		return model;
	}
	
	@GetMapping("/all")
	public List<Register> getAllData() {
		
		return regDao.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public TestModel registerUser(@RequestBody Register user) {
		regDao.save(user);
		model.setMesssage("Register Success");
		model.setStatus("Success");
		return model;
	}
}
