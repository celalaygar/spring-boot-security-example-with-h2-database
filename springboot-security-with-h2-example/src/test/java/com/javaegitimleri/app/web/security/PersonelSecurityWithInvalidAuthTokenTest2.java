package com.javaegitimleri.app.web.security;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaegitimleri.app.service.AppService;;

@RunWith(SpringRunner.class)
@SpringBootTest(properties="spring.profiles.active=dev")
public class PersonelSecurityWithInvalidAuthTokenTest2 {

	@Autowired
	private AppService appService;
	
	@Before
	public void setup() {
		TestingAuthenticationToken authentication=new TestingAuthenticationToken("user1", "123456","ROLE_XXX");
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	@After
	public void tearDown() {
		SecurityContextHolder.clearContext();
	}
	
	@Test(expected=AccessDeniedException.class)
	public void testFindPersonels() {
		appService.findPersonels();
		
	}
	
	
	
}
