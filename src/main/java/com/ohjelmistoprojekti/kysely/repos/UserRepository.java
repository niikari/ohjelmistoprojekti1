package com.ohjelmistoprojekti.kysely.repos;

import org.springframework.data.repository.CrudRepository;

import com.ohjelmistoprojekti.kysely.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
