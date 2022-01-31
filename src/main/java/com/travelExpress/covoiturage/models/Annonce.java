package com.travelExpress.covoiturage.models;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Annonce implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnnonce;
	
	@Column(nullable=false)
	private String dateDepart;
	
	@Column(nullable=false)
	private String heureDepart;
	
	@Basic
	@Column( nullable=false)
	private String lieuDepart;
	
	@Basic
	@Column(nullable=false)
	private String lieuArriver;
	
	@Basic
	@Column(nullable=false)
	private Integer prixFixer;
	
	@Basic
	@Column(nullable=false)
	private Integer nbrPlaces;
	
	@Basic
	private String details;

	@ManyToOne
	private Conducteur conducteur;
	
	@OneToMany(mappedBy = "annonce", fetch = FetchType.LAZY)
	private List<Reservation> reservation;
	
	public Annonce(String dateDepart,String heureDepart, String lieuDepart,  String lieuArriver, Integer prixFixer, Integer nbrPlaces,
			String details, Conducteur conducteur) {
		
		super();
		this.dateDepart = dateDepart;
		this.heureDepart= heureDepart;
		this.lieuDepart = lieuDepart;
		this.lieuArriver = lieuArriver;
		this.prixFixer = prixFixer;
		this.nbrPlaces = nbrPlaces;
		this.details = details;
		this.conducteur = conducteur;
	}

	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(Integer idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArriver() {
		return lieuArriver;
	}

	public void setLieuArriver(String lieuArriver) {
		this.lieuArriver = lieuArriver;
	}

	public Integer getPrixFixer() {
		return prixFixer;
	}

	public void setPrixFixer(Integer prixFixer) {
		this.prixFixer = prixFixer;
	}

	public Integer getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(Integer nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	

}
