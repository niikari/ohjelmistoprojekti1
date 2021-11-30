package com.ohjelmistoprojekti.kysely.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ohjelmistoprojekti.kysely.models.MakerAnswer;
import com.ohjelmistoprojekti.kysely.repos.MakerAnswerRepository;
import com.ohjelmistoprojekti.kysely.repos.MakerRepository;


@RestController
public class KyselyRestControllers {
	
	@Autowired
	private MakerAnswerRepository makerAnswerRepository;
	
	@Autowired
	private MakerRepository makerRepository;
	
	@GetMapping("/reports/{id}")
	public List<MakerAnswer> getReportsByInquiry(@PathVariable Long id) {
		List<MakerAnswer> modAnswers = new ArrayList<>();		
		List<MakerAnswer> makeranswers = (List<MakerAnswer>) makerAnswerRepository.findAll();
		
		for (MakerAnswer ans : makeranswers) {
			if (ans.getAnswer().getQuestion().getInquiry().getId() == id) {
				modAnswers.add(ans);
			}
		}
				
		return modAnswers;
		
	}
	
	@GetMapping("/makeranswers/{id}")
	public List<MakerAnswer> getReportsByInquiryAndMaker(@PathVariable Long id) {
		List<MakerAnswer> answers = makerAnswerRepository.findByMaker(makerRepository.findById(id).get());
		
		return answers;
	}
	
}







