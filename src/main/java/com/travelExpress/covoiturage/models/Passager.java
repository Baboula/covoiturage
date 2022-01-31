package com.travelExpress.covoiturage.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("passager")
public class Passager extends Compte {

	@OneToMany(mappedBy = "passager", fetch = FetchType.LAZY)
	private List<Reservation> reservation;
	
	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Passager(User user) {
		super(user);
	}

	
	public List<Reservation> getReservation() {
		return reservation;
	}

	
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
}
