package com.ohjelmistoprojekti.kysely.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohjelmistoprojekti.kysely.models.MakerAnswer;
import com.ohjelmistoprojekti.kysely.repos.InquiryRepository;
import com.ohjelmistoprojekti.kysely.repos.MakerAnswerRepository;


@RestController
public class KyselyRestControllers {

	@Autowired
	private InquiryRepository inqRepository;
	
	@Autowired
	private MakerAnswerRepository makerAnswerRepository;
	
	
	@GetMapping("/reports")
	public List<MakerAnswer> getReports() {
		
		return (List<MakerAnswer>) makerAnswerRepository.findAll();
	}
	
	
		
}
