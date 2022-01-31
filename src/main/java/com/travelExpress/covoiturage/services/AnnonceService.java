package com.travelExpress.covoiturage.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelExpress.covoiturage.models.Annonce;
import com.travelExpress.covoiturage.repositories.AnnonceRepository;

@Service
@Transactional
public class AnnonceService implements AnnonceServiceInt {

	@Autowired
	private AnnonceRepository annonceRepository;

	@Override
	public List<Annonce> getAllAnnonce() {

		return annonceRepository.findAll();
	}

	@Override
	public void SaveAnnonce(Annonce annonce) {

		this.annonceRepository.save(annonce);
	}

	// Delete annonce
	public void delete(int id) {
		annonceRepository.deleteById(id);
	}

	// get annonce by id conducteur
	public List<Annonce> getAnnonceByConducteur(Integer id) {

		return annonceRepository.findByConducteur(id);
	}

	
	//get annonce by lieux
	public List<Annonce> getBylieux(String dp, String la){
	  
	 return this.annonceRepository.findBylieux(dp, la);
 }

	@Override
	public Annonce getAnnonceById(Integer id) {
		
		Optional<Annonce> optional= annonceRepository.findById(id);
		
		Annonce annonce = null;
		if(optional.isPresent()) {
			annonce= optional.get();
		}else {
			throw new RuntimeException("annonce introuvable for id:"+id);
		}
		return annonce;
	}
	 

}
