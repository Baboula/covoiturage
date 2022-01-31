package com.travelExpress.covoiturage.models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("chauffeur")
public class Conducteur extends Compte{
	
	  @Basic
	  @Column(name="preferences",length= 255)
	  private String preferences;
	  
	  @Basic
	  
	  @Column(name="marque_voiture", length= 30)
	  private String marquevoiture ;
	  
	  @Basic
	  
	  @Column(name="couleur_voiture",length= 30) 
	  private String couleurVoiture;
	  
	  @Basic
	  @Column(name="immatriculation",length= 255) 
	  private String immatriculation;
	  
	
	  @OneToMany(mappedBy = "conducteur", fetch = FetchType.LAZY)
	  private List<Annonce> annonce;
	  
	  public Conducteur() {
		super();
		// TODO Auto-generated constructor stub
	  }
	   
		  public Conducteur(User user) {
			super(user);
		}


	public Conducteur(User user, String preferences, String marquevoiture, String couleurVoiture,
			String immatriculation) {
		super(user);
		this.preferences = preferences;
		this.marquevoiture = marquevoiture;
		this.couleurVoiture = couleurVoiture;
		this.immatriculation = immatriculation;
	}


	public String getPreferences() { return preferences; }
	  
	  public void setPreferences(String preferences) { this.preferences =
	  preferences; }

	  public String getMarquevoiture() {
			return marquevoiture;
	  }

	  public void setMarquevoiture(String marquevoiture) {
			this.marquevoiture = marquevoiture;
	  }
	  
	  public String getCouleurVoiture() { return couleurVoiture; }
	  
	  public void setCouleurVoiture(String couleurVoiture) { this.couleurVoiture =
	  couleurVoiture; }
	  
	  
	  
	  public String getImmatriculation() { return immatriculation; }
	  
	  public void setImmatriculation(String immatriculation) {  this.immatriculation = immatriculation;}
	  
	  public List<Annonce> getAnnonce() {
			return annonce;
	  }
	
	  public void setAnnonce(List<Annonce> annonce) {
			this.annonce = annonce;
	  }
	  
}

