package com.eccsm.microtransaction.securtiy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

	@Value("${service.security.secure-key-username}")
	private String USERNAME;
	@Value("${service.security.secure-key-password}")
	private String PASSWORD;

	@SuppressWarnings("deprecation")
	@Bean
	InMemoryUserDetailsManager userDetailsService() {
		// UserDetails Servisi yazılmalı
		UserDetails user = User.withDefaultPasswordEncoder().username(USERNAME).password(PASSWORD).roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		return http.build();
	}

}
