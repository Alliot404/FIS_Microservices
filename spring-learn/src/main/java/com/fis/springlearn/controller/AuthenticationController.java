package com.fis.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fis.springlearn.SpringLearnConstants;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		SpringLearnConstants.LOGGER.info("START FROM AUTHENTICATE METHOD");
		SpringLearnConstants.LOGGER.debug("AUTH HEADER -> " + authHeader);
		Map<String, String> tokens = new HashMap<String, String>();
//		tokens.put("token", "");
		String user = getUser(authHeader);
		String token = generateJwt(user);
		tokens.put("token", token);
		SpringLearnConstants.LOGGER.info("END FROM AUTHENTICATE METHOD");
		return tokens;
	}

	private String getUser(String authHeader) {
		SpringLearnConstants.LOGGER.info("START FROM GET USER METHOD");
		String encodedCredentials = authHeader.split(" ")[1];//dYweewrfjsdhfsdfbnsjdn
		byte[] credentials = Base64.getDecoder().decode(encodedCredentials);//user:pwd
		String user = new String(credentials).split(":")[0];//user
		SpringLearnConstants.LOGGER.debug("USER -> " + user);
		SpringLearnConstants.LOGGER.info("END FROM GET USER METHOD");
		return user;
	}

	private String generateJwt(String user) {
		SpringLearnConstants.LOGGER.info("START FROM GENERATE JWT METHOD");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();

		SpringLearnConstants.LOGGER.debug("TOKEN -> " + token);
		SpringLearnConstants.LOGGER.info("END FROM GENERATE JWT METHOD");

		return token;
	}
}
