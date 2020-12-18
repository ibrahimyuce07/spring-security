package com.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage") //same with .loginPage("/showMyLoginPage") 
	public String showMyLoginPage() {
		
		return "fancy-login"; 
	}
	
	//add request mapping for /access-denied
	@GetMapping("/access-denied") //same with .loginPage("/showMyLoginPage") 
	public String showAccessDenied() {
		
		return "access-denied"; 
	}
}
