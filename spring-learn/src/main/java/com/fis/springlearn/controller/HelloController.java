package com.fis.springlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.springlearn.SpringLearnConstants;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String sayHello() {
		SpringLearnConstants.LOGGER.debug("START");
		SpringLearnConstants.LOGGER.debug("END");
		return "Hello World!!";
	}
}
