package com.travelExpress.covoiturage.contollers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelExpress.covoiturage.models.Annonce;
import com.travelExpress.covoiturage.models.Reservation;
import com.travelExpress.covoiturage.repositories.AnnonceRepository;
import com.travelExpress.covoiturage.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	
	  @GetMapping("/reservation")
	  public String ViewReservationPage(Model model) {
	 
		  //get all reservation 
		  model.addAttribute("listreservation", reservationService.getAllReservation());
		  return "reservation";
	  
	  }
	 
		
		  @PostMapping("/formulaireReservation") 
		  public String goformAnnonce(@RequestParam Integer idAnnonce, Model model){
		  
		  
		  Reservation reservation = new Reservation();
		  Optional<Annonce> optional = annonceRepository.findById(idAnnonce); 
		  Annonce annonce = new Annonce();
		  	if(optional.isPresent()) { 
			  annonce= optional.get(); 
			  }else {
				  return "redirect:/index"; 
				  
			  }
		  
		  model.addAttribute("annonce", annonce);
		  model.addAttribute("reservation",reservation);
		  
		  return "formulaireReservation"; 
		  }
		 
	
		
		  @PostMapping("/saveReservation") 
		  public String SaveReservation(@ModelAttribute("reservation")Reservation reservation,Model model, @RequestParam Integer id) {
		  
		  //save annonce to BD 
		  DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); 
		  DateFormat formatTime = new SimpleDateFormat("HH:mm"); 
		  Date date = new Date();
		  
		  Optional<Annonce> optional = annonceRepository.findById(id); 
		  Annonce annonce = new Annonce();
		  	if(optional.isPresent()) { 
			  annonce= optional.get(); 
			  }else {
				  return "redirect:/index"; 
				  
			  }
		  
		  model.addAttribute("annonce", annonce);
		  
		  
		  reservation.setDateReservation(formatDate.format(date));
		  reservation.setHeureReservation(formatTime.format(date));
		  
		  Integer restant = annonce.getNbrPlaces();
		  if(reservation.getNbrPlaceReserver() <= restant) {
		  reservationService.SaveReservation(reservation); 
		  restant-=1; 
		  } 
		  else { 
			  throw new RuntimeException("Il ne reste plus de place pour ce voyage"); 
			  
		  }
		  
		  return "redirect:/reservation"; 
		  
		  }
		 
}