package com.fis.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fis.springlearn.SpringLearnConstants;
import com.fis.springlearn.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.debug(passwordEncoder().encode("pwd"));
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN").and()
//				.withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/countries").hasRole("USER")
//				.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN");
//	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
//      		.antMatchers("/countries").hasRole("USER")
//				.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
//				.antMatchers("/employees").permitAll()
				.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
