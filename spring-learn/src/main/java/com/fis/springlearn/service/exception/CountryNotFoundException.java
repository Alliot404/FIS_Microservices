package com.fis.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {

	public CountryNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryNotFoundException(String message) {
		super(message);
	}
}
