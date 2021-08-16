package com.fis.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.userservice.bean.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{number}")
	public User getUser(@PathVariable long number) {
		return new User("Abhi", 12345, "abhi@123");
	}
}
