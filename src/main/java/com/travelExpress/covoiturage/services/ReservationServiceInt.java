package com.travelExpress.covoiturage.services;

import java.util.List;

import com.travelExpress.covoiturage.models.Reservation;

public interface ReservationServiceInt {
	
	public List<Reservation> getAllReservation();
	void SaveReservation(Reservation reservation);

}
