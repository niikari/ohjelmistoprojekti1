package com.ohjelmistoprojekti.kysely.configurations;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ohjelmistoprojekti.kysely.models.Answer;
import com.ohjelmistoprojekti.kysely.models.Inquiry;
import com.ohjelmistoprojekti.kysely.models.Question;

@Component
public class RestConfig implements RepositoryRestConfigurer {

	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Inquiry.class, Question.class, Answer.class);
    }
}
