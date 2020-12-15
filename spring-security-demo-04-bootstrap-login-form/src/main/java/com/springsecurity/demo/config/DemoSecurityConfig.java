package com.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("MANAGER"))
				.withUser(users.username("susan").password("test123").roles("ADMIN"));

		//

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//configure security web paths in application, login, logout etc.
		
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser").permitAll();
		
		/*
		 * authorizeRequests: restrict access based on the HttpServletRequest
		 * anyRequest().authenticated(): Any request to the app must be authenticated(ie logged in)
		 * formLogin(): we are customizing the form login process
		 * loginPage("/"): show our custom form at the request mapping
		 * loginProcessingUrl("/"): login form should POST data to this URL for processing (check user id and pass) (see form action)
		 * permitAll(): allow everyone to see login page. no need to be logged in.
		 * */
	}

}
