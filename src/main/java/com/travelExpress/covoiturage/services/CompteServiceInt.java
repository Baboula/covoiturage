package com.travelExpress.covoiturage.services;

import java.util.Optional;

import com.travelExpress.covoiturage.models.Compte;

public interface CompteServiceInt {
	
	public Optional<Compte> GetCompteByid(Integer idCompte);

}
