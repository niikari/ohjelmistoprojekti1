package com.ohjelmistoprojekti.kysely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ohjelmistoprojekti.kysely.models.Answer;
import com.ohjelmistoprojekti.kysely.models.Inquiry;
import com.ohjelmistoprojekti.kysely.models.Question;
import com.ohjelmistoprojekti.kysely.repos.AnswerRepository;
import com.ohjelmistoprojekti.kysely.repos.InquiryRepository;
import com.ohjelmistoprojekti.kysely.repos.QuestionRepository;

@SpringBootApplication
public class KyselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(InquiryRepository inqRepo, QuestionRepository quesRepo, AnswerRepository ansRepo) {
		return (args) -> {
						
			Inquiry inquiry = new Inquiry();
			inqRepo.save(inquiry);
			
			Question question = new Question();
			question.setInquiry(inquiry);
			question.setQuest("Vastaahan tähän kysymykseen...");
			quesRepo.save(question);
			
			Answer ans1 = new Answer();
			ans1.setAnswer("Ensimmäinen kysymys");
			ans1.setQuestion(question);
			ans1.setValue(1);
			ansRepo.save(ans1);
			
			Answer ans2 = new Answer();
			ans2.setAnswer("Toinen kysymys");
			ans2.setQuestion(question);
			ans2.setValue(3);
			ansRepo.save(ans2);
			
			Answer ans3 = new Answer();
			ans3.setAnswer("Kolmas kysymys");
			ans3.setQuestion(question);
			ans3.setValue(5);
			ansRepo.save(ans3);
			
		};

	}
}
