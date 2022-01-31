package com.travelExpress.covoiturage.services;
/*
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.travelExpress.covoiturage.models.User;
import com.travelExpress.covoiturage.repositories.UserRepository;*/

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelExpress.covoiturage.models.Compte;
import com.travelExpress.covoiturage.repositories.CompteRepository;

@Service
@Transactional
public class CompteService implements CompteServiceInt {
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Optional<Compte> GetCompteByid(Integer id) {
		
		return compteRepository.findById(id);
	}


}
