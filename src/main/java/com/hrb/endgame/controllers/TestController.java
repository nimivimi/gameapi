package com.hrb.endgame.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrb.endgame.models.TestModel;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

	TestModel model = new TestModel();
	
	@GetMapping
	public TestModel getData() {
		model.setMesssage("Test working");
		model.setStatus("Success");
		return model;
	}
}
