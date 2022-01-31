package com.travelExpress.covoiturage.contollers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.travelExpress.covoiturage.models.Annonce;
import com.travelExpress.covoiturage.services.AnnonceService;

@Controller
public class AnnonceController {
	
	@Autowired
	private AnnonceService annonceService;
	
	  @GetMapping("/index")
	  public String rechercherAnnonce(Model model,String ld, String la) {
	  
	  if(ld!=null && la!=null) { 
		  model.addAttribute("annonces",annonceService.getBylieux(ld, la)); 
	   }else {
		   model.addAttribute("annonces",annonceService.getAllAnnonce() ); 
	   }
	  
	  return "index";
	  
	  }
	 
	  @GetMapping("/annonce")
	  public String getAnnonce(Model model) {
		  	
		  model.addAttribute("annonces",annonceService.getAllAnnonce()); 
		  return "annonce";
	  
	  }
	
	
		@GetMapping("/formulaireAnnonce")
		public String goformAnnonce(Model model){
			
			Annonce annonce= new Annonce();
			model.addAttribute("annonce", annonce);
			
			return "formulaireAnnonce";
		}
	
	
	  @PostMapping("/saveAnnonce") 
	  public String SaveAnnonce(@ModelAttribute("annonce")Annonce annonce) {
	  
	  //save annonce to BD 
	  DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); DateFormat formatTime = new
	  SimpleDateFormat("HH:mm"); Date date = new Date();
	  
	  annonce.setDateDepart(formatDate.format(date));
	  annonce.setHeureDepart(formatTime.format(date));
	  
	  annonceService.SaveAnnonce(annonce);
	  
	  return "redirect:/index"; 
	  
	  }
	  
	  @GetMapping("/showupdateannonce/{id}")
	  public String showupdateannonce(@PathVariable(value="id")Integer id,Model model) {
		  
		  //get annonce by service
		  Annonce annonce= annonceService.getAnnonceById(id);
		  
		  model.addAttribute("annonce", annonce);
		  
		  return "updateAnnonce";
	  }
	 
	  
}
	  	 