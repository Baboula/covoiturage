package com.travelExpress.covoiturage.contollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.travelExpress.covoiturage.models.Passager;
import com.travelExpress.covoiturage.models.User;
import com.travelExpress.covoiturage.repositories.CompteRepository;
import com.travelExpress.covoiturage.services.UserService;


@Controller
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired 
	private CompteRepository compteRepository;
	
	//Get All Users
	@GetMapping("users")
	public String findAll(Model model){		
		return "user";
	}	
	
	@RequestMapping("users/findById") 
	@ResponseBody
	public Optional<User> findById(Integer id)
	{
		return userService.findById(id);
	}
	
	//Add User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		
		userService.save(user);
		Passager passager = new Passager();
		passager.setUser(user);
		compteRepository.save(passager);
		
		RedirectView redirectView= new RedirectView("/login", true);
		
		redir.addFlashAttribute("message", "Inscription reussit ");
		
		return redirectView;
	}	
	
	@RequestMapping(value="users/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/users";
	}


}
