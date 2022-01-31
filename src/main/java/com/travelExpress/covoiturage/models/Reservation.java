package com.travelExpress.covoiturage.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Reservation implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private String dateReservation;
	

	@Column(nullable=false)
	private String heureReservation;
	
	private String modePayement;
	private Integer montantverser;
	private Integer nbrPlaceReserver;
	
	@ManyToOne
	private Passager passager;
	
	@ManyToOne
	@JoinColumn(name="annonce_id")
	private Annonce annonce;

	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Reservation(String StringReservation,String heureReservation, Integer nbrPlaceReserver, String modePayement, Passager passager, Annonce annonce) {
		super();
		this.dateReservation = StringReservation;
		this.heureReservation= heureReservation;
		this.nbrPlaceReserver= nbrPlaceReserver;
		this.modePayement = modePayement;
		this.passager = passager;
		this.annonce = annonce;
	}


	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public String getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	
	public String getHeureReservation() {
		return heureReservation;
	}


	public void setHeureReservation(String heureReservation) {
		this.heureReservation = heureReservation;
	}


	public Integer getNbrPlaceReserver() {
		return nbrPlaceReserver;
	}


	public void setNbrPlaceReserver(Integer nbrPlaceReserver) {
		this.nbrPlaceReserver = nbrPlaceReserver;
	}


	public String getModePayement() {
		return modePayement;
	}


	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}


	public Integer getMontantverser() {
		return montantverser;
	}


	public void setMontantverser(Integer montantverser) {
		this.montantverser = montantverser;
	}
	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	
	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
}
