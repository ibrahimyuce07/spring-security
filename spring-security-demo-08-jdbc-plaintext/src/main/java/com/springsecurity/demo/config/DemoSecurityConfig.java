package com.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	//add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			//use jdbc authentication ... no longer hard coding users
			auth.jdbcAuthentication().dataSource(securityDataSource);
			

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configure security web paths in application, login, logout etc.

		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/access-denied");

		/*
		 * authorizeRequests: restrict access based on the HttpServletRequest
		 * anyRequest().authenticated(): Any request to the app must be authenticated(ie
		 * logged in) formLogin(): we are customizing the form login process
		 * loginPage("/"): show our custom form at the request mapping
		 * loginProcessingUrl("/"): login form should POST data to this URL for
		 * processing (check user id and pass) (see form action) permitAll(): allow
		 * everyone to see login page. no need to be logged in. logout().permitAll():
		 * add logout support for all users.
		 * .antMatchers("/systems/**").hasRole("ADMIN"): authorize a spesific page for a role
		 * .exceptionHandling().accessDeniedPage("access-denied"): custom access denied page
		 * 
		 */
	}

}
