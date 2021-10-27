package com.ohjelmistoprojekti.kysely.repos;

import org.springframework.data.repository.CrudRepository;

import com.ohjelmistoprojekti.kysely.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
