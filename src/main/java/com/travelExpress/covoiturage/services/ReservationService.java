package com.travelExpress.covoiturage.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelExpress.covoiturage.models.Reservation;
import com.travelExpress.covoiturage.repositories.ReservationRepository;

@Service
@Transactional
public class ReservationService implements ReservationServiceInt {
		
	@Autowired
	private ReservationRepository reservationRepository;
	

	@Override
	public List<Reservation> getAllReservation() {
		
		return reservationRepository.findAll();
	}
	
	
	@Override
	public void SaveReservation(Reservation reservation) {
		
		this.reservationRepository.save(reservation);	
	}
	
	
	//Get reservation by idAnnonce
	public List<Reservation> getReservationByIdAnnnonce(Integer id){
		
		return reservationRepository.findByIdannonce(id);
		
	}
	
	
}
