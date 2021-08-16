package com.fis.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.springlearn.bean.User;
import com.fis.springlearn.repository.UserRepository;
import com.fis.springlearn.service.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@GetMapping("/{username}")
	public UserDetails findByUsername(@PathVariable String username) {
		return appUserDetailsService.loadUserByUsername(username);
	}

//	@Autowired
//	private UserRepository userRepository;

//	@GetMapping("/{username}")
//	public User findByUsername(@PathVariable String username) {
//		return userRepository.findByUsername(username);
//	}

}
