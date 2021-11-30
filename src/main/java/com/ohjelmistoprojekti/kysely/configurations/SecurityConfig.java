package com.ohjelmistoprojekti.kysely.configurations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ohjelmistoprojekti.kysely.AuthenticationFilter;
import com.ohjelmistoprojekti.kysely.LoginFilter;
import com.ohjelmistoprojekti.kysely.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServiceImpl userDetailsService; 
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable().cors().and().authorizeRequests()
      .antMatchers(HttpMethod.POST, "/login").permitAll()
      // TÄMÄ PITÄÄ MUOKATA LOPUKSI NIIN ETTEI KÄYTTÄJIÄ (USERS TAI MAKERS) PÄÄSE HAKEMAAN
      //.antMatchers(HttpMethod.GET, "/api", "/api/**").permitAll()
      .antMatchers(HttpMethod.GET, "/api/inquiries", "/api/inquiries/**").permitAll()
      .antMatchers(HttpMethod.GET, "/api/answers", "/api/answers/**").permitAll()
      .antMatchers(HttpMethod.GET, "/api/questions", "/api/questions/**").permitAll()
      .antMatchers(HttpMethod.GET, "/makeranswers", "/makeranswers/**").permitAll()
      .antMatchers(HttpMethod.POST, "/api/makerAnswers").permitAll()
      //.antMatchers(HttpMethod.POST, "/api/makers").permitAll()
      //.antMatchers(HttpMethod.GET, "/api/makers").permitAll()
          .anyRequest().authenticated()
          .and()
          // Filter for the api/login requests
          .addFilterBefore(new LoginFilter("/login",
           authenticationManager()),
                  UsernamePasswordAuthenticationFilter.class)
          // Filter for other requests to check JWT in header
          .addFilterBefore(new AuthenticationFilter(),
                  UsernamePasswordAuthenticationFilter.class);
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService)
	  .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = 
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowedOrigins(Arrays.asList("https://kyselyfrontend.herokuapp.com", "http://localhost:3000/", "http://kyselyfrontend.herokuapp.com", "http://kyselyfrontend.herokuapp.com/**"));
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        //config.setAllowCredentials(true);
        config.applyPermitDefaultValues();
        
        source.registerCorsConfiguration("/**", config);
        return source;
  }
	
}
