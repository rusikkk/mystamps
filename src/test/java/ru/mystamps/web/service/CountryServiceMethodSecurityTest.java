/*
 * Copyright (C) 2012 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package ru.mystamps.web.service;

import java.util.Collections;

import javax.inject.Inject;

import org.testng.annotations.Test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import ru.mystamps.web.config.ApplicationContext;
import ru.mystamps.web.config.TestContext;

@ActiveProfiles("test")
@ContextConfiguration(
	loader = AnnotationConfigContextLoader.class,
	classes = {
		ApplicationContext.class,
		TestContext.class
	}
)
public class CountryServiceMethodSecurityTest extends AbstractTestNGSpringContextTests {
	
	@Inject
	private CountryService service;
	
	@Value("${valid_user_login}")
	private String validUserLogin;
	
	@Value("${valid_user_password}")
	private String validUserPassword;
	
	//
	// Tests for add()
	//
	
	@Test(expectedExceptions = AccessDeniedException.class)
	public void addShouldDenyAccessToAnonymousUser() {
		authenticateAsAnonymous();
		
		service.add(null);
	}
	
	@Test
	public void addShouldAllowAccessToAuthenticatedUser() {
		authenticateAsUser(validUserLogin, validUserPassword);
		
		service.add("Any Country Name");
	}
	
	private static void authenticateAsAnonymous() {
		final Authentication authentication = new AnonymousAuthenticationToken(
			"anonymous",
			"anonymous",
			Collections.singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))
		);
		
		authenticate(authentication);
	}
	
	private static void authenticateAsUser(final String login, final String password) {
		final Authentication authentication =
			new UsernamePasswordAuthenticationToken(login, password);
		
		authenticate(authentication);
	}
	
	private static void authenticate(final Authentication authentication) {
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
}
