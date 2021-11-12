package com.ohjelmistoprojekti.kysely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ohjelmistoprojekti.kysely.models.Answer;
import com.ohjelmistoprojekti.kysely.models.Inquiry;
import com.ohjelmistoprojekti.kysely.models.Question;
import com.ohjelmistoprojekti.kysely.models.User;
import com.ohjelmistoprojekti.kysely.repos.AnswerRepository;
import com.ohjelmistoprojekti.kysely.repos.InquiryRepository;
import com.ohjelmistoprojekti.kysely.repos.MakerRepository;
import com.ohjelmistoprojekti.kysely.repos.QuestionRepository;
import com.ohjelmistoprojekti.kysely.repos.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class KyselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(InquiryRepository inqRepo, QuestionRepository quesRepo, AnswerRepository ansRepo,
			MakerRepository makerRepository, UserRepository userRepository) {
		return (args) -> {
						
			Inquiry inquiry = new Inquiry();
			inquiry.setName("Ensimmäinen kysely");
			inqRepo.save(inquiry);
			
			Question question = new Question();
			question.setInquiry(inquiry);
			question.setQuest("Vastaahan tähän kysymykseen...");
			quesRepo.save(question);
			
			Answer ans1 = new Answer();
			ans1.setAnswer("Ensimmäinen vastaus");
			ans1.setQuestion(question);
			ans1.setValue(1);
			ansRepo.save(ans1);
			
			Answer ans2 = new Answer();
			ans2.setAnswer("Toinen vastaus");
			ans2.setQuestion(question);
			ans2.setValue(3);
			ansRepo.save(ans2);
			
			Answer ans3 = new Answer();
			ans3.setAnswer("Kolmas vastaus");
			ans3.setQuestion(question);
			ans3.setValue(5);
			ansRepo.save(ans3);
			
			Question question2 = new Question();
			question2.setInquiry(inquiry);
			question2.setQuest("Vastaahan tähän toiseenkin kysymykseen...");
			quesRepo.save(question2);
			
			Answer ans4 = new Answer();
			ans4.setAnswer("Toisen kysymyksen ensimmäinen vastaus");
			ans4.setQuestion(question2);
			ans4.setValue(1);
			ansRepo.save(ans4);
			
			Answer ans5 = new Answer();
			ans5.setAnswer("Toisen kysymyksen toinen vastaus");
			ans5.setQuestion(question2);
			ans5.setValue(3);
			ansRepo.save(ans5);
			
			Answer ans6 = new Answer();
			ans6.setAnswer("Toisen kysymyksen kolmas vastaus");
			ans6.setQuestion(question2);
			ans6.setValue(5);
			ansRepo.save(ans6);
			
			Question question3 = new Question();
			question3.setInquiry(inquiry);
			question3.setQuest("Tämä on avoin kysymys, runoile...");
			question3.setNormQuestion(false);
			question3.setOpenQuestion(true);
			quesRepo.save(question3);
			
			Answer ans7 = new Answer();
			ans7.setQuestion(question3);
			ansRepo.save(ans7);
			
			Question question4 = new Question();
			question4.setInquiry(inquiry);
			question4.setQuest("Vastaahan tähän kolmanteen, useampi vaihtoehto ok");
			question4.setNormQuestion(false);
			question4.setMultipleAnswers(true);
			quesRepo.save(question4);
			
			Answer ans8 = new Answer();
			ans8.setAnswer("Kolmannen kysymyksen ensimmäinen vastaus");
			ans8.setQuestion(question4);
			ans8.setValue(1);
			ansRepo.save(ans8);
			
			Answer ans9 = new Answer();
			ans9.setAnswer("Kolmannen kysymyksen toinen vastaus");
			ans9.setQuestion(question4);
			ans9.setValue(3);
			ansRepo.save(ans9);
			
			Answer ans10 = new Answer();
			ans10.setAnswer("Kolmannen kysymyksen kolmas vastaus");
			ans10.setQuestion(question4);
			ans10.setValue(5);
			ansRepo.save(ans10);
			
			User user = new User();
			user.setUsername("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setRole("admin");
			userRepository.save(user);
		};

	}
}
