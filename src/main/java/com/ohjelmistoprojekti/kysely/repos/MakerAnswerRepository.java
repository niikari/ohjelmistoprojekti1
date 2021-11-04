package com.ohjelmistoprojekti.kysely.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ohjelmistoprojekti.kysely.models.Maker;
import com.ohjelmistoprojekti.kysely.models.MakerAnswer;

@RepositoryRestResource
public interface MakerAnswerRepository extends CrudRepository<MakerAnswer, Long> {

	// FETCH FROM SPECIFIC USER
	List<MakerAnswer> findByMaker(@Param("maker") Maker maker);
}
