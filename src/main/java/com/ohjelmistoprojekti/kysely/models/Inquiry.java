package com.ohjelmistoprojekti.kysely.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonIgnore
	@OneToMany(mappedBy="inquiry", cascade=CascadeType.REMOVE)
	private List<Question> questions = new ArrayList<>();
	
	@Column(unique=true)
	private String name;
	
	// VOISI LAITTAA MYÖS PÄIVÄN KOSKA TEHTY
	
	// VOISI LAITTAA MYÖS PÄIVÄN KOSKA MUOKATTU
	
}
