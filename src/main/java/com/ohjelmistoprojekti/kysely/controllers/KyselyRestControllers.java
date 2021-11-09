package com.ohjelmistoprojekti.kysely.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohjelmistoprojekti.kysely.models.MakerAnswer;
import com.ohjelmistoprojekti.kysely.repos.MakerAnswerRepository;

@RestController
public class KyselyRestControllers {

	@Autowired
	private MakerAnswerRepository makerAnswerRepository;
	
	@GetMapping("/")
	public MakerAnswer report() {
		
		
		return null;
	}
	
}
