package com.travelExpress.covoiturage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(){	
		
		return "register";
	}

}
