package com.fis.springlearn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fis.springlearn.bean.User;
import com.fis.springlearn.repository.UserRepository;
import com.fis.springlearn.security.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;
	
	

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		LOGGER.info("Start");
//		LOGGER.debug("UserRepository:{}", userRepository);

		User user = userRepository.findByUsername(username);
//		LOGGER.debug("User:{}", user);

		if (user == null) {
			throw new UsernameNotFoundException("User not found !!!");
		}

//		LOGGER.info("End");

		return new AppUser(user);
	}

}
