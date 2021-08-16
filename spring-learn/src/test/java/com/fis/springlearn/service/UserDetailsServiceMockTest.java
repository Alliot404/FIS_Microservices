package com.fis.springlearn.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fis.springlearn.bean.Role;
import com.fis.springlearn.bean.User;
import com.fis.springlearn.repository.UserRepository;
import com.fis.springlearn.service.AppUserDetailsService;

@SpringBootTest
public class UserDetailsServiceMockTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceTest.class);

	@Test
	public void mockTestLoadUserByUsername() {
		LOGGER.info("Start");
		UserRepository repository = Mockito.mock(UserRepository.class);
		when(repository.findByUsername("usr")).thenReturn(createUser());
		// repository refers to the mock repository created
		UserDetailsService service = new AppUserDetailsService(repository);
		UserDetails user = service.loadUserByUsername("usr");
		String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
		assertEquals(expected, user.getPassword());
		LOGGER.info("End");
	}

	@Test
	public void mockTestLoadByUserNameWithUserNull() {
		LOGGER.info("Start");
		UserRepository repository = Mockito.mock(UserRepository.class);
		when(repository.findByUsername("user")).thenReturn(null);
		UserDetailsService service = new AppUserDetailsService(repository);
		try {
			UserDetails user = service.loadUserByUsername("usr1");
			LOGGER.debug("user:{}", user);
		} catch (UsernameNotFoundException e) {
			LOGGER.error("User not found", e);
			assertTrue(true);
			return;
		}
		assertFalse(true);
		LOGGER.info("End");
	}

	private User createUser() {
		User user = new User();
		user.setId(1);
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");

		Role role = new Role();
		role.setId(1);
		role.setName("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoleList(roles);

		return user;
	}

}
