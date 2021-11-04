package com.ohjelmistoprojekti.kysely.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String answer;
	
	private int value = 0;
	
	@ManyToOne
	private Question question;
	
	@JsonIgnore
	@OneToMany(mappedBy="answer")
	private List<MakerAnswer> makerAnswers = new ArrayList<>();
}
