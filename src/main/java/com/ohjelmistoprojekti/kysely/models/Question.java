package com.ohjelmistoprojekti.kysely.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String quest;

	private Boolean multipleAnswers = false;
	private Boolean openQuestion = false;
	private Boolean normQuestion = true;
		
	@ManyToOne
	private Inquiry inquiry;
	
	@JsonIgnore
	@OneToMany(mappedBy="question", cascade=CascadeType.REMOVE)
	private List<Answer> answers = new ArrayList<>();
	
}
