package com.travelExpress.covoiturage.services;

import java.util.List;

import com.travelExpress.covoiturage.models.Annonce;

public interface AnnonceServiceInt {
	
	public List<Annonce> getAllAnnonce();
	void SaveAnnonce(Annonce annonce);
	Annonce getAnnonceById(Integer id);

}
