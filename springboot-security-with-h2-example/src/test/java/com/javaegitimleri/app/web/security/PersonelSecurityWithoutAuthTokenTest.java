package com.javaegitimleri.app.web.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaegitimleri.app.service.AppService;;

@RunWith(SpringRunner.class)
@SpringBootTest(properties="spring.profiles.active=dev")
public class PersonelSecurityWithoutAuthTokenTest {

	@Autowired
	private AppService appService;
	
	@Test(expected=AuthenticationCredentialsNotFoundException.class)
	public void testFindPersonels() {
		appService.findPersonels();
		
	}
	
	
	
}
