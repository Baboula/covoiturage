package com.travelExpress.covoiturage.contollers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travelExpress.covoiturage.services.UserService;

@Controller
public class ProfileController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/newprofile")
	public String profile(Model model, Principal principal) {
		
		String un = principal.getName();
		model.addAttribute("users", userService.findByUsername(un));
		
		return "newprofile";
	}
}
